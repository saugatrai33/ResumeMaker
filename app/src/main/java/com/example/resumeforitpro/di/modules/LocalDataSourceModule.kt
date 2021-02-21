package com.example.resumeforitpro.di.modules

import com.example.resumeforitpro.datasource.local.LocalDataSource
import com.example.resumeforitpro.datasource.local.dao.ProfileDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(profileDao: ProfileDao) =
        LocalDataSource(profileDao)

}