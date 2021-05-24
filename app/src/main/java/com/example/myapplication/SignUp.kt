package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    private lateinit var signIn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signIn=findViewById(R.id.registered)
        signIn.setOnClickListener(){

            val intent: Intent = Intent(applicationContext, MainActivity::class.java)

            startActivity(intent)
        }
    }
}