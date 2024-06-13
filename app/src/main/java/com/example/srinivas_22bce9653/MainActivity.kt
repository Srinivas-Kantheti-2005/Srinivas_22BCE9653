package com.example.srinivas_22bce9653

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name:String = "Srinivas"
        Log.i(TAG, "onCreate")
        Toast.makeText(this, "Activity Created", Toast.LENGTH_SHORT).show()

        // Link the click handler to a button
        val button = findViewById<Button>(R.id.loginbtn) // Replace 'your_button_id' with the actual ID of your button
        button.setOnClickListener {
            clickHandler(it)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
        Toast.makeText(this, "Activity Started", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
        Toast.makeText(this, "Activity Resumed", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
        Toast.makeText(this, "Activity Paused", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
        Toast.makeText(this, "Activity Stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
        Toast.makeText(this, "Activity Destroyed", Toast.LENGTH_SHORT).show()
    }

    // Fixed clickHandler function signature
    fun clickHandler(view: View) {
        Log.i("MainActivity-clickhandler", "Button clicked")

        // Uncomment the lines below to use dial or web intents
        // val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:7075322769"))
        // val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
        // startActivity(webIntent)

        var c= 10+20
        add(10, 20)
        val hIntent = Intent(this, HomeActivity::class.java)
        hIntent.putExtra("mykey", "android-vit-Srinivas")
        // throw NullPointerException("demo vit exception")
        startActivity(hIntent)
    }

    private fun add(i: Int, i1: Int):Int {
        var c = 20
        var d = 20 * i
        mul(5, 4)
        return i + i1
    }

    private fun mul(i: Int, i1: Int) {
        val d = i * i1
        div(6,3)
    }

    private fun div(i: Int, i1: Int) {
        add(10, 20)
    }

    fun inflatexml() {
        var nameEditText = EditText(this)
        nameEditText.setHint("Enter ur username")
        var pwdEditText = EditText(this)
        pwdEditText.setHint("Enter ur pin")
        val loginButton = Button(this)
        loginButton.setText("LOGIN")
    }
}
