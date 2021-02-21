package com.example.resumeforitpro.ui.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.resumeforitpro.R
import com.example.resumeforitpro.data.local.DatabaseBuilder
import com.example.resumeforitpro.data.local.DatabaseHelperImpl
import com.example.resumeforitpro.data.local.entity.Profile
import com.example.resumeforitpro.utils.ResumeViewModelFactory
import com.example.resumeforitpro.utils.Status
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import java.io.File

class ProfileActivity : AppCompatActivity() {

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;

        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    private var CODEINSERTUPDATE: Int = 0

    private lateinit var profileViewModel: ProfileViewModel

    private var profilePhoto: SimpleDraweeView? = null
    private var profileName: EditText? = null
    private var profileAddress: EditText? = null
    private var profilePhone: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_profile)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        profileViewModel = ViewModelProviders.of(
            this,
            ResumeViewModelFactory(
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(ProfileViewModel::class.java)
        setupProfileObserver()

        val fileName = "Resume Picture"
        val dir = File(Environment.getExternalStorageDirectory(), fileName)
        if (!dir.exists()) {
            dir.mkdir()
        }

        profilePhoto = findViewById(R.id.img_profile)
        profileName = findViewById(R.id.text_profile_name)
        profileAddress = findViewById(R.id.text_profile_address)
        profilePhone = findViewById(R.id.text_profile_phone)
        val btnSave = findViewById<Button>(R.id.btn_profile_save)
        btnSave.setOnClickListener { getProfileNSave() }
        profilePhoto!!.setOnClickListener { checkPhotoPermission() }

    }

    private fun checkPhotoPermission() {
        //check runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED
            ) {
                //permission denied
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                //show popup to request runtime permission
                requestPermissions(permissions, PERMISSION_CODE);
            } else {
                //permission already granted
                pickImageFromGallery();
            }
        } else {
            //system OS is < Marshmallow
            pickImageFromGallery();
        }
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(
                        this, R.string.permission_denied,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            profilePhoto!!.setImageURI(data?.data)
        }
    }

    /**
     * Get the profile data from UI and send to local db.
     * */
    private fun getProfileNSave() {
        val name: String = profileName!!.text.toString().trim()
        val address: String = profileAddress!!.text.toString().trim()
        val phoneNum: String = profilePhone!!.text.toString().trim()

        if (name.isEmpty() || address.isEmpty() || phoneNum.isEmpty()) {
            Toast.makeText(
                this, R.string.msg_profile_null,
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val profile = Profile(
            name = name,
            address = address,
            phone = phoneNum.toLong(),
            profileImgPath = ""
        )

        if (CODEINSERTUPDATE == 0) {
            profileViewModel.saveProfileToDb(newProfile = profile)
        } else {
            profileViewModel.updateProfile(updatedProfile = profile)
        }


    }

    private fun setupProfileObserver() {
        profileViewModel.getProfile().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { profile ->
                        CODEINSERTUPDATE = 1
                        profileName!!.setText(profile.name)
                        profileAddress!!.setText(profile.address)
                        profilePhone!!.setText(profile.phone.toString())
                    }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Log.d("MainActivity", "setupProfileObserver: error")
                }
            }
        })
    }

    // Checks if a volume containing external storage is available
// for read and write.
    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    // Checks if a volume containing external storage is available to at least read.
    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }


}