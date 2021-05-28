package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth



class SignUp : AppCompatActivity() {

    private var mFirebaseAuthAuth: FirebaseAuth? = null
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var mobileNumber:EditText
    private lateinit var emailId:EditText
    private lateinit var govtId:EditText
    private lateinit var initialPassword:EditText
    private lateinit var confirmPassword:EditText
    private lateinit var signUp: Button;

    private lateinit var signIn: Button;

    private var isValid:Boolean=true




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        signIn.setOnClickListener(){

            val intent: Intent = Intent(applicationContext, MainActivity::class.java)

            startActivity(intent)
        }
    }

    private fun createUser(){

        if(firstName.text.toString().isEmpty()){
            firstName.error="Please Enter the First Name"
            firstName.requestFocus()
            isValid=false
        }
        if(lastName.text.toString().isEmpty()){
            lastName.error="Please Enter the Last Name"
            lastName.requestFocus()
            isValid=false
        }
        if(mobileNumber.text.toString().isEmpty()){
            mobileNumber.error="Please Enter the Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }
        if(!Patterns.PHONE.matcher(mobileNumber.text.toString()).matches()){
            mobileNumber.error="Please Enter valid Mobile Number"
            mobileNumber.requestFocus()
            isValid=false
        }
        if(emailId.text.toString().isEmpty()){
            emailId.error="Please Enter the Email"
            emailId.requestFocus()
            isValid=false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailId.text.toString()).matches()){
            emailId.error="Please Enter valid Email"
            emailId.requestFocus()
            isValid=false
        }
        if(govtId.text.toString().isEmpty()){
            govtId.error="Please Enter Your Government Id"
            govtId.requestFocus()
            isValid=false
        }
        if(initialPassword.text.toString().isEmpty()){
            initialPassword.error="Please Enter initial Password"
            initialPassword.requestFocus()
            isValid=false
        }
        if(confirmPassword.text.toString().isEmpty()) {
            confirmPassword.error = "Please Enter confirmation password"
            confirmPassword.requestFocus()
            isValid=false
        }

        if(isValid){
            var firstName=firstName.text.toString()
            var mobileNumber=mobileNumber.text.toString()
            var confirmPassword=confirmPassword.text.toString()

            Toast.makeText(this,"User SignUp Successful",Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)

            intent.putExtra("name",firstName)
            intent.putExtra("mobileNumber",mobileNumber)
            intent.putExtra("password",confirmPassword)

            startActivity(intent)

        }else{
            Toast.makeText(this,"User SignUp Failed",Toast.LENGTH_LONG).show()
        }

        /*var firstName=firstName.text.toString()
        var lastName=lastName.text.toString()
        var mobileNumber=mobileNumber.text.toString()
        var emailId=emailId.text.toString()
        var govtId=govtId.text.toString()
        var initialPassword=initialPassword.text.toString()
        var confirmPassword=confirmPassword.text.toString()

        fireBaseDataBase= FirebaseDatabase.getInstance()
        reference=fireBaseDataBase.getReference("Users")

        userdata.firstName=firstName
        userdata.lastName=lastName
        userdata.mobileNumber=mobileNumber
        userdata.emailId=emailId
        userdata.govtId=govtId
        userdata.initialPassword=initialPassword
        userdata.confirmPassword=confirmPassword

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                reference.setValue(userdata)


                Toast.makeText(baseContext, "data added", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                
                Toast.makeText(baseContext,"Fail to add data $error", Toast.LENGTH_SHORT)
                    .show()
            }
        })*/
    }
}