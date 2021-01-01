package com.example.resumeforitpro.data.local

import android.content.Context
import androidx.room.Room
import com.example.resumeforitpro.utils.Constants

object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDb(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDb(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        Constants.DB_NAME
    ).build()

}