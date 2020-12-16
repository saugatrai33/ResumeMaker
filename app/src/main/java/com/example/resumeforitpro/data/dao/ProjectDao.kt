package com.example.resumeforitpro.data.dao

import androidx.room.*

@Dao
interface ProjectDao {

    @Query("SELECT * FROM profile")
    suspend fun getProject()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject()

    @Update
    suspend fun updateProject()

    @Delete
    suspend fun deleteProject()
}