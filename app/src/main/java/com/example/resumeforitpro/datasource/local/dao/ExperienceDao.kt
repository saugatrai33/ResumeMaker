package com.example.resumeforitpro.datasource.local.dao

import androidx.room.*
import com.example.resumeforitpro.datasource.local.entity.Experience

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