package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.core.text.HtmlCompat

class CovidTest : AppCompatActivity() {

    private lateinit var takeCovidTest:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide()
        setContentView(R.layout.activity_covid_test)

        takeCovidTest=findViewById(R.id.takeCovidTest)

        takeCovidTest.setOnClickListener {
            val toast = Toast.makeText(this, HtmlCompat.fromHtml(
                "<font color='#00ff00' ><b>Select an Hospital to take Covid-19 test.</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, Positive::class.java)

            startActivity(intent)
        }


    }
}