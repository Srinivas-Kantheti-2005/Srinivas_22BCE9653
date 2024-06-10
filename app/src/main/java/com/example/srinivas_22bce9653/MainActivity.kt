package com.example.srinivas_22bce9653

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.preference.PreferenceManager
import java.util.Locale

fun updateLocale(context: Context, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = Configuration()
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the saved language preference
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val language = prefs.getString("language", "en") ?: "en"
        updateLocale(this, language)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val changelanguage = findViewById<Button>(R.id.changelanguage)

        loginbtn.setOnClickListener {
            clickHandler(username.text.toString(), password.text.toString())
        }

        changelanguage.setOnClickListener {
            val newLanguage = if (language == "en") "te" else "en"
            prefs.edit().putString("language", newLanguage).apply()
            updateLocale(this, newLanguage)
            restartActivity()
        }
    }

    private fun restartActivity() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun clickHandler(username: String, password: String) {
        Log.i("MainActivity-clickhandler", "button clicked")
        if (username == "Srinivas" && password == "7075322769") {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:7075322769"))
            startActivity(dialIntent)
        } else {
            Toast.makeText(this, "Login Failed!!!", Toast.LENGTH_SHORT).show()
        }
    }
}