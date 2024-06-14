package com.example.srinivas_22bce9653

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var data = arrayOf("India", "Telugu", "Australia", "Peacock", "blue")
    var TAG = HomeActivity::class.java.simpleName  //"Home Activity"
    lateinit var mySpinner: Spinner
    lateinit var myRecycle: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        mySpinner = findViewById(R.id.spinner)  //taking handler
        myRecycle = findViewById(R.id.recyclerView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mySpinner.onItemSelectedListener = this
//        mylistView.setOnItemClickListener(this)
        /* var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity", "data is = "+data)
        val homeTextView: TextView = findViewById(R.id.tvhome)
        homeTextView.setText(data) */


    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}