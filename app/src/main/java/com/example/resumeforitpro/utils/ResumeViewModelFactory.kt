package com.example.resumeforitpro.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.resumeforitpro.data.local.DatabaseHelper
import com.example.resumeforitpro.ui.profile.ProfileViewModel
import java.lang.IllegalArgumentException

/**
 * Factory to generate ViewModels.
 *
 * @param databaseHelper the database of the app.
 *
 * @throws IllegalArgumentException unknown ViewModel class.
 * */
class ResumeViewModelFactory(
    private val databaseHelper: DatabaseHelper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(databaseHelper) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class:: ")
    }
}