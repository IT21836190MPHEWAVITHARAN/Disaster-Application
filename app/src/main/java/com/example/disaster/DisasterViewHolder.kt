package com.example.disaster

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.disaster.database.Disaster
import com.bumptech.glide.Glide

class DisasterViewHolder(view:View):ViewHolder(view) {
    val DImage: ImageView = view.findViewById(R.id.DImage)
    val Dtitle: TextView = view.findViewById(R.id.Dtitle)
    val DDistrict: TextView = view.findViewById(R.id.DDistrict)
    val DDis: TextView = view.findViewById(R.id.DDis)

    fun bind(disaster: Disaster) {
        Dtitle.text = disaster.title
        DDistrict.text = disaster.district
        DDis.text = disaster.dis


        // Load and display the image using Glide
        disaster.photoPath?.let { path ->
            Glide.with(DImage.context)
                .load(Uri.parse(path)) // Assuming the photoPath is a valid URI
                .into(DImage)
        }
    }

}