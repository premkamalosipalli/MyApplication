package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var signIn: Button;
    lateinit var signUp: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signIn=findViewById(R.id.gotoSignIn)
        signUp=findViewById(R.id.gotoSignUp)

        signIn.setOnClickListener(){

            val intent:Intent = Intent(applicationContext, SignIn::class.java)

            startActivity(intent)
        }

        signUp.setOnClickListener(){

            val intent:Intent = Intent(applicationContext, SignUp::class.java)

            startActivity(intent)
        }
    }
}