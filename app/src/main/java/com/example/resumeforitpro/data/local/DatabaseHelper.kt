package com.example.resumeforitpro.data.local

import com.example.resumeforitpro.data.local.entity.Profile

interface DatabaseHelper {
    suspend fun getProfile(): Profile

    suspend fun insertProfile(profile: Profile)

    suspend fun updateProfile(profile: Profile)

    suspend fun deleteProfile(profile: Profile)
}