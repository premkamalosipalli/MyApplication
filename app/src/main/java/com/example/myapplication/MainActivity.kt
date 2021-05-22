package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var signUp: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUp=findViewById(R.id.gotoSignUp)



        signUp.setOnClickListener(){

            val intent:Intent = Intent(applicationContext, SignUp::class.java)

            startActivity(intent)
        }
    }
}