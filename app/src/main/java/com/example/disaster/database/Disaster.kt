package com.example.disaster.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Disaster(
    var title:String?,
    var district:String?,
    var dis:String?,
    var photoPath:String?,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}