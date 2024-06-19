package com.example.srinivas_22bce9653

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.srinivas_22bce9653.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    var TAG = HomeActivity::class.java.simpleName  //"Home Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }



    private fun getMarsPhotos() {
        GlobalScope.launch {

            var listMarsPhotos = MarsApi.retrofitService.getPhotos()
            var tvHome:TextView = findViewById(R.id.tvhome)
            tvHome.setText(listMarsPhotos.get(1).imgSrc)
            Log.i("homeactivity", listMarsPhotos.size.toString())
        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

}