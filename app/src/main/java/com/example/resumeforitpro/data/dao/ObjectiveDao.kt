package com.example.resumeforitpro.data.dao

import androidx.room.*
import com.example.resumeforitpro.data.model.Objective

@Dao
interface ObjectiveDao {

    @Query("SELECT * FROM objective")
    suspend fun getObjective(): Objective

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObjective()

    @Update
    suspend fun updateObjective()

    @Delete
    suspend fun deleteObjective()
}