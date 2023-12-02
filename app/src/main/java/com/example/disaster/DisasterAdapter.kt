package com.example.disaster

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.disaster.database.Disaster
import com.example.disaster.database.DisasterRepository

class DisasterAdapter(items:List<Disaster>, repository: DisasterRepository,viewMode:MainActivityData):Adapter<DisasterViewHolder>(){
    lateinit var  context:Context

    val items =items
    val repository=repository
    val viewModel=viewMode

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisasterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewdisaster,parent,false)
        return DisasterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DisasterViewHolder, position: Int) {
        val disaster = items[position]
        holder.Dtitle.text = disaster.title
        holder.DDistrict.text = disaster.district
        holder.DDis.text = disaster.dis
        holder.DImage


    }

}