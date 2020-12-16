package com.example.resumeforitpro.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "experience")
class Experience(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "experience_id")
    private val experienceId: Long,

    @NonNull
    private val company: String,

    @NonNull
    private val title: String,

    @NonNull
    @ColumnInfo(name = "start_date")
    private val startDate: Date,

    @NonNull
    @ColumnInfo(name = "end_date")
    private val endDate: Date
)