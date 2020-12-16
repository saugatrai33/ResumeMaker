package com.example.resumeforitpro.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skill")
class Skill(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skill_id")
    private val skillId: Long,

    @NonNull
    @ColumnInfo(name = "skill_title")
    private val skillTitle: String
)