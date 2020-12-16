package com.example.resumeforitpro.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
class Project(
    @ColumnInfo(name = "project_id")
    @PrimaryKey(autoGenerate = true)
    private val projectId: Long,

    @NonNull
    private val title: String,

    @NonNull
    private val description: String
)