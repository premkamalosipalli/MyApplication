package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private var mFirebaseAuthAuth: FirebaseAuth? = null
    private lateinit var mobileNumber: EditText
    private lateinit var password: EditText

    private lateinit var signIn: Button;
    private lateinit var signUp: Button;

    private lateinit var userdata:UserData
    private var isValid:Boolean=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAuthAuth = FirebaseAuth.getInstance()
        mobileNumber=findViewById(R.id.phoneNumber)
        password=findViewById(R.id.password)
        signIn=findViewById(R.id.gotoSignIn)

        signIn.setOnClickListener{
            view->loginUser()
        }

        signUp=findViewById(R.id.gotoSignUp)
        signUp.setOnClickListener(){
            val intent:Intent = Intent(applicationContext, SignUp::class.java)

            startActivity(intent)
        }
    }

    private fun loginUser(){

        if(mobileNumber.text.toString().isEmpty()){
            mobileNumber.error="Please Enter the Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }
        /*if(!Patterns.PHONE.matcher(mobileNumber.text.toString()).matches()){
            mobileNumber.error="Please Enter valid Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }*/
        if(password.text.toString().isEmpty()) {
            password.error = "Please Enter confirmation password"
            password.requestFocus()
            isValid=false
        }
        if(isValid) {
            if (userdata.mobileNumber === "8978892848" &&
                userdata.confirmPassword === "123456"
            ) {
                val intent: Intent = Intent(applicationContext, Welcome::class.java)

                startActivity(intent)
            }
        }
    }
}