package com.example.resumeforitpro.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumeforitpro.data.model.Profile

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