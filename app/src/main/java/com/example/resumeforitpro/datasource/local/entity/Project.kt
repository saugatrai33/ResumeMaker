package com.example.resumeforitpro.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
data class Project(
    @ColumnInfo(name = "project_id")
    @PrimaryKey(autoGenerate = true)
    var projectId: Long,

    @NonNull
    var title: String,

    @NonNull
    var description: String
)