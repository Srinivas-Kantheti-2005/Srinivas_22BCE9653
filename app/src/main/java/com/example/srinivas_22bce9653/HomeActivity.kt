package com.example.srinivas_22bce9653

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    lateinit var viewModel: HomeViewModel
    //var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.seconds.observe(this, sescObserver)

        //binding.tvhome.setText(""+viewModel.count)
        binding.btnInc.setOnClickListener {
            //count++
            viewModel.IncrementCount()
            binding.tvhome.setText(""+viewModel.count)
        }

        binding.btnDbInsert.setOnClickListener {
            insertDataDb()
        }

        binding.btnFind.setOnClickListener {
            findItemDb(21)
        }

        binding.btnTimer.setOnClickListener {
            viewModel.startTimer()
            binding.tvhome.setText(""+viewModel.seconds)
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

    val sescObserver: Observer<Int> = object: Observer<Int> {
        override fun onChanged(observedValue: Int) {
            //receiving the update/ notification
            binding.tvhome.setText(observedValue.toString())
        }
    }

    fun showNotification(view: View) {
        createNotificationChannel()
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, "promotions")
            .setSmallIcon(R.drawable.baseline_email_24)
            .setContentTitle("Vit email")
            .setContentText("Android app development")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            var notifManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notifManager.notify(12, builder.build())
        }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // The NotificationChannel class is not in the Support Library.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channelname"
            val descriptionText = "channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("promotions", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}