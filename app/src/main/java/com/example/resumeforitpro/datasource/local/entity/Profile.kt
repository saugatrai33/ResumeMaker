package com.example.resumeforitpro.datasource.local.entity

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "profile_id")
    var profileId: Long? = null,

    @NonNull
    var name: String,

    @NonNull
    var address: String,

    @NonNull
    var phone: Long,

    @Nullable
    @ColumnInfo(name = "profile_img_path")
    var profileImgPath: String
)