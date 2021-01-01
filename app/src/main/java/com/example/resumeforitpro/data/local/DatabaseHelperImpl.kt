package com.example.resumeforitpro.data.local

import com.example.resumeforitpro.data.local.entity.Profile

class DatabaseHelperImpl(
    private val appDatabase: AppDatabase
) : DatabaseHelper {
    override suspend fun getProfile(): Profile =
        appDatabase.profileDao.getProfile()

    override suspend fun insertProfile(profile: Profile) =
        appDatabase.profileDao.insertProfile(profile)

    override suspend fun updateProfile(profile: Profile) =
        appDatabase.profileDao.updateProfile(profile)

    override suspend fun deleteProfile(profile: Profile) =
        appDatabase.profileDao.deleteProfile(profile)
}