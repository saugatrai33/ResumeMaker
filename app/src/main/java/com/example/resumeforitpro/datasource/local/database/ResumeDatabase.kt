package com.example.resumeforitpro.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.resumeforitpro.datasource.local.dao.*
import com.example.resumeforitpro.datasource.local.entity.*
import com.example.resumeforitpro.utils.DateConverter

@Database(
    entities = [Education::class, Experience::class, Objective::class,
        Profile::class, Project::class, Skill::class], version = 1, exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ResumeDatabase : RoomDatabase() {
    abstract val educationDao: EducationDao
    abstract val experienceDao: ExperienceDao
    abstract val objectiveDao: ObjectiveDao
    abstract val profileDao: ProfileDao
    abstract val projectDao: ProjectDao
    abstract val skillDao: SkillDao
}