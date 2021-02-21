package com.example.resumeforitpro.di.component

import android.content.Context
import com.example.resumeforitpro.datasource.local.database.ResumeDatabase
import com.example.resumeforitpro.di.modules.AppModule
import com.example.resumeforitpro.di.modules.DatabaseModule
import com.example.resumeforitpro.di.modules.LocalDataSourceModule
import com.example.resumeforitpro.di.modules.RepositoryModule
import com.example.resumeforitpro.ui.profile.ProfileActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class
    ]
)
interface ResumeComponents {
    fun context(): Context
    fun resumeDatabase(): ResumeDatabase

    fun inject(profileActivity: ProfileActivity)
}