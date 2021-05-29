package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Welcome : AppCompatActivity() {
    private lateinit var userName: TextView
    private lateinit var takeSurvey: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        userName = findViewById(R.id.userName)
        takeSurvey = findViewById(R.id.takeSurvey)

        val intent: Intent = intent
        val username = intent.getStringExtra("name")

        userName.text = "Hello, $username"

        takeSurvey.setOnClickListener() {
            val intent = Intent(applicationContext, TakeSurvey::class.java)

            startActivity(intent)
        }

    }
}