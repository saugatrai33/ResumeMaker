package com.example.resumeforitpro.di.modules

import android.app.Application
import androidx.room.Room
import com.example.resumeforitpro.datasource.local.dao.*
import com.example.resumeforitpro.datasource.local.database.ResumeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(application: Application) {

    private val database = Room.databaseBuilder(
        application,
        ResumeDatabase::class.java,
        "resume_db"
    )

    @Provides
    @Singleton
    fun provideRoomDatabase(): ResumeDatabase = database.build()

    @Provides
    @Singleton
    fun provideEducationDao(resumeDatabase: ResumeDatabase): EducationDao =
        resumeDatabase.educationDao

    @Provides
    @Singleton
    fun provideExperienceDao(resumeDatabase: ResumeDatabase): ExperienceDao =
        resumeDatabase.experienceDao

    @Provides
    @Singleton
    fun provideProfileDao(resumeDatabase: ResumeDatabase): ProfileDao =
        resumeDatabase.profileDao

    @Provides
    @Singleton
    fun provideProjectDao(resumeDatabase: ResumeDatabase): ProjectDao =
        resumeDatabase.projectDao

    @Provides
    @Singleton
    fun provideSkillDao(resumeDatabase: ResumeDatabase): SkillDao =
        resumeDatabase.skillDao

}