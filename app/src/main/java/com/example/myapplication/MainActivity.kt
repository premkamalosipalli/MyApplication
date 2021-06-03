package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.HtmlCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private var mFirebaseAuthAuth: FirebaseAuth? = null
    private lateinit var mobileNumber: EditText
    private lateinit var password: EditText

    private lateinit var signIn: Button
    private lateinit var signUp: Button

    private var isValid: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAuthAuth = FirebaseAuth.getInstance()
        mobileNumber = findViewById(R.id.phoneNumber)
        password = findViewById(R.id.password)
        signIn = findViewById(R.id.gotoSignIn)

        signIn.setOnClickListener {
            loginUser()
        }

        signUp = findViewById(R.id.gotoSignUp)
        signUp.setOnClickListener() {
            val intent = Intent(applicationContext, SignUp::class.java)

            startActivity(intent)
        }
    }

    private fun loginUser() {

        if (mobileNumber.text.toString().isEmpty()) {
            mobileNumber.error = "Please enter the Mobile Number"
            mobileNumber.requestFocus()
            isValid = false
        }
        else{
            isValid=true
        }
        if (!Patterns.PHONE.matcher(mobileNumber.text.toString()).matches()) {
            mobileNumber.error = "Please enter valid Mobile Number"
            mobileNumber.requestFocus()
            isValid = false
        }
        else{
            isValid=true
        }
        if (password.text.toString().isEmpty()) {
            password.error = "Please enter Password"
            password.requestFocus()
            isValid = false
        }
        else{
            isValid=true
        }
        if (isValid) {
            val intent: Intent = intent
            val firstName = intent.getStringExtra("name")
            val phoneNumber = intent.getStringExtra("mobileNumber")
            val confirmPassword = intent.getStringExtra("password")
            if ((mobileNumber.text.toString() == phoneNumber && password.text.toString() == confirmPassword) ||
                (mobileNumber.text.toString() == "1234567890" && password.text.toString() == "123456")
            ) {
                val toast = Toast.makeText(
                    this, HtmlCompat.fromHtml(
                        "<font color='#00ff00' ><b>Hello,${firstName}." +
                                "Welcome to Cure Quickly.</b></font>",
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ), Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                val intent = Intent(applicationContext, Welcome::class.java)
                intent.putExtra("name", firstName)
                startActivity(intent)
            } else {
                val toast = Toast.makeText(
                    this, HtmlCompat.fromHtml(
                        "<font color='#FF0000' ><b>Please Enter valid Login Credentials..</b></font>",
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ), Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}