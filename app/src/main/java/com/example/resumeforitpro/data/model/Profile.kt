package com.example.resumeforitpro.data.model

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "profile_id")
    private val profileId: Long,

    @NonNull
    private val name: String,

    @NonNull
    private val address: String,

    @NonNull
    private val phone: Long,

    @Nullable
    @ColumnInfo(name = "profile_img_path")
    private val profileImgPath: String
)