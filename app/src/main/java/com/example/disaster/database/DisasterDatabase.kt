package com.example.disaster.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Disaster::class], version = 1)
abstract class DisasterDatabase:RoomDatabase(){
    abstract fun getDisasterDao():DisasterDao

    companion object{
        @Volatile
        private var INSTANCE:DisasterDatabase?=null

        fun getInstance(context:Context):DisasterDatabase{
            synchronized(this){
                return INSTANCE?:Room.databaseBuilder(
                    context,
                    DisasterDatabase::class.java,
                    "Disaster_db"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE=it
                }
            }
        }
    }

}