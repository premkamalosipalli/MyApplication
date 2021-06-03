package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat

class Welcome : AppCompatActivity() {
    private lateinit var userName: TextView
    private lateinit var takeSurvey: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_welcome)

        userName = findViewById(R.id.userName)
        takeSurvey = findViewById(R.id.takeSurvey)

        val intent: Intent = intent
        val username = intent.getStringExtra("name")

        userName.text = "Hello, $username"

        takeSurvey.setOnClickListener() {
            val toast = Toast.makeText(this, HtmlCompat.fromHtml(
                "<font color='#00ff00' ><b>Welcome to the Survey.</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, TakeSurvey::class.java)

            startActivity(intent)
        }

    }
}