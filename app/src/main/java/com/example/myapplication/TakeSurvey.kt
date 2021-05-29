package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

abstract class TakeSurvey : AppCompatActivity() {
    private lateinit var submit: Button
    private var isColdRadioButtonChecked: Boolean? = null
    private var isFeverRadioButtonChecked: Boolean? = null
    private var isCoughRadioButtonChecked: Boolean? = null
    private var isBodyPainsRadioButtonChecked: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_survey)

        submit = findViewById(R.id.submit)

        submit.setOnClickListener() {
            submitSurvey()
        }

    }

    private fun submitSurvey() {
        if (isColdRadioButtonChecked===null || isCoughRadioButtonChecked===null
            || isFeverRadioButtonChecked===null || isBodyPainsRadioButtonChecked===null
        ) {
            val toast = Toast.makeText(this, HtmlCompat.fromHtml("<font color='#FF0000' ><b>Please fill all the questions</b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0,0)
            toast.show()


        }else if (isColdRadioButtonChecked===true ||isCoughRadioButtonChecked ===true ||
            isFeverRadioButtonChecked===true || isBodyPainsRadioButtonChecked===true){
            val intent = Intent(applicationContext, CovidTest::class.java)

            startActivity(intent)
        }
        else {
            val intent = Intent(applicationContext, Negative::class.java)

            startActivity(intent)
        }
    }

    fun onColdRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.cold_yes ->
                    if (checked) {
                        isColdRadioButtonChecked = true
                    }
                R.id.cold_no ->
                    if (checked) {
                        isColdRadioButtonChecked = false
                    }
            }
        }
    }

    fun onFeverRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.cold_yes ->
                    if (checked) {
                        isFeverRadioButtonChecked = true
                    }
                R.id.cold_no ->
                    if (checked) {
                        isFeverRadioButtonChecked = false
                    }
            }
        }
    }

    fun onCoughRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.cold_yes ->
                    if (checked) {
                        isCoughRadioButtonChecked = true
                    }
                R.id.cold_no ->
                    if (checked) {
                        isCoughRadioButtonChecked = false
                    }
            }
        }
    }

    fun onBodyPainsRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.cold_yes ->
                    if (checked) {
                        isBodyPainsRadioButtonChecked = true
                    }
                R.id.cold_no ->
                    if (checked) {
                        isBodyPainsRadioButtonChecked = false
                    }
            }
        }
    }
}