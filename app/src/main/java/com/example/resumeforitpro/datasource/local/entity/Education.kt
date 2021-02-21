package com.example.resumeforitpro.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "education")
data class Education(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "education_id")
    var educationId: Long,

    @NonNull
    var course: String,

    @NonNull
    var university: String,

    var score: Int? = 0,

    @ColumnInfo(name = "graduation_date")
    var graduationDate: Date
)