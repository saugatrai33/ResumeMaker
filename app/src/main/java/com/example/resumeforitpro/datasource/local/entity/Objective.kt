package com.example.resumeforitpro.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "objective")
data class Objective(

    @ColumnInfo(name = "objective_id")
    @PrimaryKey(autoGenerate = true)
    var objectiveId: Long,

    var title: String
)