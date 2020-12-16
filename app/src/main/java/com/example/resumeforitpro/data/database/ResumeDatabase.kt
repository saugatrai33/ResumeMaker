package com.example.resumeforitpro.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.resumeforitpro.data.dao.*
import com.example.resumeforitpro.data.model.*

@Database(
    entities = [Education::class, Experience::class, Objective::class,
        Profile::class, Project::class, Skill::class], version = 1, exportSchema = false
)
abstract class ResumeDatabase : RoomDatabase() {

    abstract val educationDao: EducationDao
    abstract val experienceDao: ExperienceDao
    abstract val objectiveDao: ObjectiveDao
    abstract val profileDao: ProfileDao
    abstract val projectDao: ProjectDao
    abstract val skillDao: SkillDao

    companion object {
        @Volatile
        private var INSTANCE: ResumeDatabase? = null

        fun getInstance(context: Context): ResumeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ResumeDatabase::class.java,
                        "resume_db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}