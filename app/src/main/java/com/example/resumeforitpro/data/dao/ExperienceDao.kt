package com.example.resumeforitpro.data.dao

import androidx.room.*

@Dao
interface ExperienceDao {

    @Query("SELECT * FROM experience")
    suspend fun getExperience()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExperience()

    @Update
    suspend fun updateExperience()

    @Delete
    suspend fun deleteExperience()
}