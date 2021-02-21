package com.example.resumeforitpro.ui.profile

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.resumeforitpro.R
import com.example.resumeforitpro.data.local.DatabaseBuilder
import com.example.resumeforitpro.data.local.DatabaseHelperImpl
import com.example.resumeforitpro.utils.ResumeViewModelFactory
import com.example.resumeforitpro.utils.Status
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    private var profilePhoto: SimpleDraweeView? = null
    private var profileName: EditText? = null
    private var profileAddress: EditText? = null
    private var profilePhone: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_profile)

        profileViewModel = ViewModelProviders.of(
            this,
            ResumeViewModelFactory(
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(ProfileViewModel::class.java)

        profilePhoto = findViewById(R.id.img_profile)
        profileName = findViewById(R.id.text_profile_name)
        profileAddress = findViewById(R.id.text_profile_address)
        profilePhone = findViewById(R.id.text_profile_phone)
        val btnSave = findViewById<Button>(R.id.btn_profile_save)

    }

    private fun setupProfileObserver() {
        profileViewModel.getProfile().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { profile ->
                        Log.d("MainActivity", "profileName:: ${profile.name}")
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

}