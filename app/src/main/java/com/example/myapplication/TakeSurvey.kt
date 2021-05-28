package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TakeSurvey : AppCompatActivity() {
    private lateinit var submit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_survey)

        submit=findViewById(R.id.submit)

        submit.setOnClickListener(){
            val intent: Intent = Intent(applicationContext, CovidTest::class.java)

            startActivity(intent)
        }

    }
}