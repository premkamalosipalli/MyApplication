package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.core.text.HtmlCompat

class Negative : AppCompatActivity() {

    private lateinit var logout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_negative)

        logout=findViewById(R.id.logout)

        logout.setOnClickListener() {
            val toast = Toast.makeText(this, HtmlCompat.fromHtml(
                "<font color='#00ff00' ><b>Thanks You. Have a Nice Day</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, MainActivity::class.java)

            startActivity(intent)
        }
    }
}