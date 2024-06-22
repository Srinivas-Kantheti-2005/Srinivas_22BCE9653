package com.example.srinivas_22bce9653

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srinivas_22bce9653.databinding.ActivityHomeBinding
import com.example.srinivas_22bce9653.network.MarsApi
import com.example.srinivas_22bce9653.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// wet codes --- dry codes -- repetitive lines will be removed
class HomeActivity : AppCompatActivity() {

    var TAG = HomeActivity::class.java.simpleName  //"Home Activity"

    private lateinit var binding: ActivityHomeBinding
    val photoMarsDatabinding = MarsPhoto("007", "moonimage.com")

    //lateinit var marsRecyclerView:RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos: List<MarsPhoto>
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
//        var homeTextView:TextView = findViewById(R.id.tvhome)
//        homeTextView.setText(photoMarsDatabinding.imgSrc)
        binding.marsphotoxml = photoMarsDatabinding

        //imageView = findViewById(R.id.imageView)
        //marsRecyclerView = findViewById(R.id.recyclerViewUrls)
        binding.recyclerViewUrls.layoutManager = LinearLayoutManager(this)
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
        binding.recyclerViewUrls.adapter = marsAdapter

//        marsAdapter = MarsAdapter(photos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            // Perform coroutine operations here
        }
    }

    private fun enableEdgeToEdge() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            // launching coroutines in the main thread is not advisable
            var listMarsPhoto = MarsApi.retrofitService.getPhotos()
//            photos = listMarsPhoto
            marsAdapter.listMarsPhoto = listMarsPhoto
//            import coil.load
            //imageView.load(listMarsPhoto.get(0).imgSrc)
            marsAdapter.notifyDataSetChanged()
//            var tvhome:TextView = findViewById(R.id.tvhome)
//            tvhome.setText(listMarsPhoto.get(1).imgSrc)
            //binding.imageView.load()
            Log.i("homeactivity", listMarsPhoto.size.toString())
            Log.i("homeactivity-url", listMarsPhoto.get(1).imgSrc)
        }
    }

    fun getjson(view: View) {
        getMarsPhotos()
    }
}
