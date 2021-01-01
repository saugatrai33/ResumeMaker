package com.example.resumeforitpro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Experience

@Dao
interface ExperienceDao {

    @Query("SELECT * FROM experience")
    suspend fun getExperience(): Experience

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExperience(experience: Experience)

    @Update
    suspend fun updateExperience(experience: Experience)

    @Delete
    suspend fun deleteExperience(experience: Experience)
}