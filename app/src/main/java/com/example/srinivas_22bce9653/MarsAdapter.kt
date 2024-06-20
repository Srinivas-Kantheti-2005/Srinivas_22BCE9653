package com.example.srinivas_22bce9653

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srinivas_22bce9653.network.MarsPhoto

class MarsAdapter(var listMarsPhoto: List<MarsPhoto>) :RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {
    class MarsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textView:TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        var rowPlank = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return MarsViewHolder(rowPlank)
    }

    override fun getItemCount(): Int {
        return listMarsPhoto.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        holder.textView.setText(listMarsPhoto.get(position).imgSrc)
    }
}