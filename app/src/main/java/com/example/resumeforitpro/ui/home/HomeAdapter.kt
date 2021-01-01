package com.example.resumeforitpro.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumeforitpro.R

class HomeAdapter(
    private val context: Context,
    private val homes: List<Home>,
    private val onHomeItemClickListener: OnHomeItemClickListener
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeText: TextView = itemView.findViewById(R.id.row_title)
        val homeImg: ImageView = itemView.findViewById(R.id.row_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.row_home_view, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home = homes[position]
        holder.homeImg.setImageResource(home.homeImgResId)
        val homeText = context.resources.getString(home.homeTextResId)
        holder.homeText.text = homeText
        holder.itemView
            .setOnClickListener { onHomeItemClickListener.onHomeItemClick(homeText) }
    }

    override fun getItemCount(): Int {
        return homes.size
    }

}