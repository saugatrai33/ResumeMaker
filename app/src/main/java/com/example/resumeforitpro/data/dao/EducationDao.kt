package com.example.resumeforitpro.data.dao

import androidx.room.*
import com.example.resumeforitpro.data.model.Education

@Dao
interface EducationDao {

    @Query("SELECT * FROM education")
    suspend fun getEducation(): Education

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEducation()

    @Update
    suspend fun updateEducation()

    @Delete
    suspend fun deleteEducation()
}