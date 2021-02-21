package com.example.resumeforitpro.datasource.local

import com.example.resumeforitpro.datasource.local.dao.ProfileDao
import com.example.resumeforitpro.datasource.local.entity.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Get data locally stored in room database
 * */
class LocalDataSource(
    private val profileDao: ProfileDao
) {

    suspend fun insertProfile(profile: Profile) =
        withContext(Dispatchers.IO) {
            profileDao.insertProfile(profile)
        }

}