package com.example.resumeforitpro.data.local.dao

import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Project

@Dao
interface ProjectDao {

    @Query("SELECT * FROM project")
    suspend fun getProject(): Project

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: Project)

    @Update
    suspend fun updateProject(project: Project)

    @Delete
    suspend fun deleteProject(project: Project)
}