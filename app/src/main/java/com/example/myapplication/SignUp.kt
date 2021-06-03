package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.*


class SignUp : AppCompatActivity() {

    private var mFirebaseAuthAuth: FirebaseAuth? = null
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var mobileNumber:EditText
    private lateinit var emailId:EditText
    private lateinit var govtId:EditText
    private lateinit var initialPassword:EditText
    private lateinit var confirmPassword:EditText
    private lateinit var signUp: Button

    private lateinit var signIn: Button

    private var isValid:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_up)

        mFirebaseAuthAuth = FirebaseAuth.getInstance()

        firstName=findViewById(R.id.firstName)
        lastName=findViewById(R.id.lastName)
        mobileNumber=findViewById(R.id.mobileNumber)
        emailId=findViewById(R.id.emailId)
        govtId=findViewById(R.id.govtId)
        initialPassword=findViewById(R.id.firstPassword)
        confirmPassword=findViewById(R.id.confirmPassword)
        signUp=findViewById(R.id.registered)
        signUp.setOnClickListener{

            createUser()
        }

        signIn=findViewById(R.id.signIn)
        signIn.setOnClickListener {

            val intent = Intent(applicationContext, MainActivity::class.java)

            startActivity(intent)
        }
    }

    private fun createUser(){

        if(firstName.text.toString().isEmpty()){
            firstName.error="Please enter the First Name"
            firstName.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(lastName.text.toString().isEmpty()){
            lastName.error="Please enter the Last Name"
            lastName.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(mobileNumber.text.toString().isEmpty()){
            mobileNumber.error="Please enter the Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(!Patterns.PHONE.matcher(mobileNumber.text.toString()).matches()){
            mobileNumber.error="Please enter valid Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(emailId.text.toString().isEmpty()){
            emailId.error="Please enter the Email"
            emailId.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailId.text.toString()).matches()){
            emailId.error="Please enter valid Email"
            emailId.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(govtId.text.toString().isEmpty()){
            govtId.error="Please enter Your Government Id"
            govtId.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(initialPassword.text.toString().isEmpty()){
            initialPassword.error="Please enter Initial Password"
            initialPassword.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(confirmPassword.text.toString().isEmpty()) {
            confirmPassword.error = "Please enter Confirmation Password"
            confirmPassword.requestFocus()
            isValid=false
        }
        else{
            isValid=true
        }
        if(isValid){
            val firstName=firstName.text.toString()
            val mobileNumber=mobileNumber.text.toString()
            val confirmPassword=confirmPassword.text.toString()

            val toast = Toast.makeText(this, HtmlCompat.fromHtml(
                "<font color='#00ff00' ><b>User Registered Successful</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ),Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, MainActivity::class.java)

            intent.putExtra("name",firstName)
            intent.putExtra("mobileNumber",mobileNumber)
            intent.putExtra("password",confirmPassword)

            startActivity(intent)

        }
        /*else{
            val toast = Toast.makeText(this,HtmlCompat.fromHtml(
                "<font color='#FF0000' ><b>Registration Failed,Please try again after some tine.</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ),Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }*/


    }
}