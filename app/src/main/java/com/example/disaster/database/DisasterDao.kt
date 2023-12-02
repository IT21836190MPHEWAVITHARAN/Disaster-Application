package com.example.disaster.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DisasterDao {
    @Insert
    suspend fun insert(disaster:Disaster)

    @Delete
    suspend fun delete(disaster: Disaster)

    @Query("SELECT * FROM Disaster")
    fun getAllDisaster():List<Disaster>

}