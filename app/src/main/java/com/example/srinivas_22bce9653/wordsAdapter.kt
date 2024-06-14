package com.example.srinivas_22bce9653

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(var dataArray: Array<String>) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

    private val TAG = WordsViewHolder::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        // Inflate the raw_layout_xml file in memory
        Log.i(TAG, "Sumanth bought a row of plank")
        val rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_item, parent, false)
        return WordsViewHolder(rowPlank)
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "Daya counted --${dataArray.size}")
        return dataArray.size
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        // Bind the data to the TextView in each row
        Log.i(TAG, "Lokesh writing --"+dataArray[position]+"on the textview shown by Titas")
        holder.tvRowItem.setText(dataArray[position])
    }

    class WordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            Log.i("WordsAdapter", "Titas is finding the textview in a row")
        }

        var tvRowItem: TextView = itemView.findViewById(R.id.tvRow)
    }
}
