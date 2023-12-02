package com.example.disaster.database

class DisasterRepository (private val db:DisasterDatabase){
    suspend fun insert(disaster: Disaster) = db.getDisasterDao().insert(disaster)
    suspend fun delete(disaster: Disaster) = db.getDisasterDao().delete(disaster)

    fun getAllDisaster():List<Disaster> = db.getDisasterDao().getAllDisaster()
}