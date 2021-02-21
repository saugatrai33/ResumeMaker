package com.example.resumeforitpro.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumeforitpro.datasource.local.entity.Profile
import com.example.resumeforitpro.repository.ResumeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val resumeRepository: ResumeRepository
) : ViewModel() {

    fun insertProfile(profile: Profile) =
        viewModelScope.launch {
            resumeRepository.insertProfile(profile)
        }

}