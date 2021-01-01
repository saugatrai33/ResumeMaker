package com.example.resumeforitpro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumeforitpro.data.local.entity.Objective

@Dao
interface ObjectiveDao {

    @Query("SELECT * FROM objective")
    suspend fun getObjective(): Objective

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObjective(objective: Objective)

    @Update
    suspend fun updateObjective(objective: Objective)

    @Delete
    suspend fun deleteObjective(objective: Objective)
}