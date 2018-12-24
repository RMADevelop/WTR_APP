package com.wtr.wtr_app.presentation.components.map

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wtr.wtr_app.R
import kotlinx.android.synthetic.main.item_weather_hours.view.*

class HoursAdapter : RecyclerView.Adapter<HoursViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {

        return HoursViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather_hours, parent, false))

    }

    override fun getItemCount(): Int = 100

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        holder.bind()
    }
}

class HoursViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind() {
        view.hours_text.text = adapterPosition.toString()
    }
}

