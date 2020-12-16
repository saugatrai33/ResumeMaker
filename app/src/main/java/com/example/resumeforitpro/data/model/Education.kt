package com.example.resumeforitpro.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "education")
class Education(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "education_id")
    private val educationId: Long,

    @NonNull
    private val course: String,

    @NonNull
    private val university: String,

    private val score: Int,

    @ColumnInfo(name = "graduation_date")
    private val graduationDate: Date
)