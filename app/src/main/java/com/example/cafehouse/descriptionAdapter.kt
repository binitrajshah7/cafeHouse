package com.example.cafehouse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class descriptionAdapter(val context: Context, private val list: ArrayList<titleAndDescription>) :
    RecyclerView.Adapter<descriptionAdapter.viewHolder>() {

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.description_layout, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val currentItem = list[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return list.size
    }
}