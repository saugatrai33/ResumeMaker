package com.example.resumeforitpro.data.local.dao

import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Profile

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile")
    suspend fun getProfile(): Profile

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)
}