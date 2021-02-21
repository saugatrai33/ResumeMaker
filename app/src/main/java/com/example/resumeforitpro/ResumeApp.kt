package com.example.resumeforitpro

import android.app.Application
import com.example.resumeforitpro.di.component.DaggerResumeComponents
import com.example.resumeforitpro.di.modules.AppModule
import com.example.resumeforitpro.di.modules.DatabaseModule
import com.example.resumeforitpro.di.component.ResumeComponents

class ResumeApp : Application() {

    val resumeComponents: ResumeComponents by lazy {
        DaggerResumeComponents.builder()
            .appModule(AppModule(this))
            .databaseModule(DatabaseModule(this))
            .build()
    }


}