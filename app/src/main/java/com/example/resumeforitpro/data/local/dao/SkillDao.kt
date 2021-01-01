package com.example.resumeforitpro.data.local.dao

import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Skill

@Dao
interface SkillDao {

    @Query("SELECT * FROM skill")
    suspend fun getSkills(): Skill

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkill(skill: Skill)

    @Update
    suspend fun updateSkill(skill: Skill)

    @Delete
    suspend fun deleteSkill(skill: Skill)
}