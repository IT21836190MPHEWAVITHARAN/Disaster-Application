package com.example.disaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.disaster.database.Disaster

class MainActivityData:ViewModel() {
    private val _data = MutableLiveData<List<Disaster>>()

    val data:LiveData<List<Disaster>> = _data

    fun setData(data:List<Disaster>){
        _data.value = data
    }
}