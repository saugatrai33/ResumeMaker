package com.example.resumeforitpro.data.dao

import androidx.room.*

@Dao
interface SkillDao {

    @Query("SELECT * FROM skill")
    suspend fun getSkills()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkill()

    @Update
    suspend fun updateSkill()

    @Delete
    suspend fun deleteSkill()
}