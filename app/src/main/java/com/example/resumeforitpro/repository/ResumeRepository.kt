package com.example.resumeforitpro.repository

import com.example.resumeforitpro.datasource.local.LocalDataSource
import com.example.resumeforitpro.datasource.local.entity.Profile

class ResumeRepository(
    private val localDataSource: LocalDataSource
) {

    suspend fun insertProfile(profile: Profile) {
        localDataSource.insertProfile(profile)
    }

}