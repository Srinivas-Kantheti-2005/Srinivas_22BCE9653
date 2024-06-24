package com.example.srinivas_22bce9653

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.srinivas_22bce9653.database.Item
import com.example.srinivas_22bce9653.database.ItemDao
import com.example.srinivas_22bce9653.database.ItemRoomDatabase
import com.example.srinivas_22bce9653.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    var TAG = HomeActivity::class.java.simpleName  //"Home Activity"
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

        binding.btnDbInsert.setOnClickListener {
            insertDataDb()
        }

        binding.btnFind.setOnClickListener {
            findItemDb(21)
        }
    }

    private fun findItemDb(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(id).first()
            binding.tvhome.setText(item.itemName)
        }
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }
}