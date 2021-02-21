package com.example.resumeforitpro.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "experience")
data class Experience(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "experience_id")
    var experienceId: Long,

    @NonNull
    var company: String,

    @NonNull
    var title: String,

    @NonNull
    @ColumnInfo(name = "start_date")
    var startDate: Date,

    @NonNull
    @ColumnInfo(name = "end_date")
    var endDate: Date
)