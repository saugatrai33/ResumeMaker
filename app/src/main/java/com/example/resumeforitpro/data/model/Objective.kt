package com.example.resumeforitpro.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "objective")
class Objective(

    @ColumnInfo(name = "objective_id")
    @PrimaryKey(autoGenerate = true)
    private val objectiveId: Long,

    private val title: String
)