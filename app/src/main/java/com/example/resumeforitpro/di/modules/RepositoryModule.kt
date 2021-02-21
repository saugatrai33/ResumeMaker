package com.example.resumeforitpro.di.modules

import com.example.resumeforitpro.datasource.local.LocalDataSource
import com.example.resumeforitpro.repository.ResumeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryModule(localDataSource: LocalDataSource) =
        ResumeRepository(localDataSource)

}