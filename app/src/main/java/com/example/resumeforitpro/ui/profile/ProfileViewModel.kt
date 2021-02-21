package com.example.resumeforitpro.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumeforitpro.data.local.DatabaseHelper
import com.example.resumeforitpro.data.local.entity.Profile
import com.example.resumeforitpro.utils.Resource
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val databaseHelper: DatabaseHelper
) : ViewModel() {
    private val profile = MutableLiveData<Resource<Profile>>()

    init {
        viewModelScope.launch {
            profile.postValue(Resource.loading(null))
            profile.postValue(Resource.success(databaseHelper.getProfile()))
        }
    }

    /**
     * Save profile to room database
     *
     * @param newProfile the updated profile.
     * */
    fun saveProfileToDb(newProfile: Profile) {
        viewModelScope.launch {
            profile.postValue(Resource.loading(null))
            databaseHelper.insertProfile(profile = newProfile)
            profile.postValue(Resource.success(data = newProfile))
        }
    }

    fun updateProfile(updatedProfile: Profile) {
        viewModelScope.launch {
            profile.postValue(Resource.loading(null))
            databaseHelper.updateProfile(updatedProfile)
            profile.postValue(Resource.success(data = updatedProfile))
        }
    }

    /**
     * Get the update profile from room database.
     * */
    fun getProfile(): LiveData<Resource<Profile>> {
        return profile
    }
}