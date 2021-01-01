package com.example.resumeforitpro.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skill")
data class Skill(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skill_id")
    var skillId: Long,

    @NonNull
    @ColumnInfo(name = "skill_title")
    var skillTitle: String
)