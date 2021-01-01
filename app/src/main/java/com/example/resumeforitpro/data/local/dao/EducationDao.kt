package com.example.resumeforitpro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Education
import com.example.resumeforitpro.data.local.entity.Experience

@Dao
interface EducationDao {

    @Query("SELECT * FROM education")
    suspend fun getEducation(): Education

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEducation(education: Education)

    @Update
    suspend fun updateEducation(education: Education)

    @Delete
    suspend fun deleteEducation(education: Education)
}