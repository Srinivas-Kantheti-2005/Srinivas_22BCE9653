package com.example.srinivas_22bce9653

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var dataArray = arrayOf("India", "Telugu", "Australia", "Peacock", "blue")
    var TAG = HomeActivity::class.java.simpleName  //"Home Activity"
    lateinit var mySpinner: Spinner
    lateinit var myRecycle: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        mySpinner = findViewById(R.id.spinner)  //taking handler
        myRecycle = findViewById(R.id.recyclerView)
        myRecycle.layoutManager = GridLayoutManager(this, 2)
            //LinearLayoutManager(this)
        val wordsAdapter = WordsAdapter(dataArray)
        myRecycle.adapter = wordsAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mySpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // No action needed
    }

    fun getShowText(view: View) {
        var etUI:EditText = findViewById(R.id.etUItest)
        var text = etUI.text.toString()
        var tvUi:TextView = findViewById(R.id.tvUI)
        tvUi.setText(text)
    }

    // suspend itself -- resume
    fun downloadImage() {
        // 50
        // 10
        // 11-20 -- internet/ database/ image processing
    }

    //http://openweathermap.com/getWeather/city=guntur
    fun getWeather(cityName:String) :String {
        // query the database and get the data.
        return "{ temp:32, windspeed:40,}"
    }

    //http://openweathermap.com/getTemp/city=25
    fun getTemp(city:String):Int {
        return 25
    }
}
