package com.example.resumeforitpro.datasource.local.dao

import androidx.room.*
import com.example.resumeforitpro.datasource.local.entity.Education

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