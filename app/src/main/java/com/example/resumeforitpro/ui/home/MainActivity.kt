package com.example.resumeforitpro.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumeforitpro.R
import com.example.resumeforitpro.ui.profile.ProfileActivity
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity(), OnHomeItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.home_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this,
            3)
        val adapter = HomeAdapter(
            this,
            loadHomes(),
            this
        )
        recyclerView.adapter = adapter

    }

    private fun loadHomes(): List<Home> {
        return listOf(
            Home(R.string.profile, R.drawable.ic_baseline_account_circle_24),
            Home(R.string.education, R.drawable.ic_baseline_account_circle_24),
            Home(R.string.experience, R.drawable.ic_baseline_account_circle_24),
            Home(R.string.skill, R.drawable.ic_baseline_account_circle_24),
            Home(R.string.project, R.drawable.ic_baseline_account_circle_24)
        )
    }

    override fun onHomeItemClick(homeItem: String) {
        if (homeItem == getString(R.string.profile)) {
            startActivity(Intent(this,
                ProfileActivity::class.java))
        }
    }
}
