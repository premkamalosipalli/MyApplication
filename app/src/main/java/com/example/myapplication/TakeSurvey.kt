package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat

class TakeSurvey : AppCompatActivity() {
    private lateinit var submit: Button
    private var isColdRadioButtonChecked: Boolean? = null
    private var isFeverRadioButtonChecked: Boolean? = null
    private var isCoughRadioButtonChecked: Boolean? = null
    private var isBodyPainsRadioButtonChecked: Boolean? = null
    private lateinit var coldRadioGroup: RadioGroup
    private  lateinit var coughRadioButton: RadioGroup
    private lateinit var feverRadioButton: RadioGroup
    private lateinit var bodypainsRadioButton: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_take_survey)

        coldRadioGroup = findViewById(R.id.cold_group)
        // Get radio group selected item using on checked change listener
        coldRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            isColdRadioButtonChecked = radio.text.contentEquals("Yes")
        }

        coughRadioButton = findViewById(R.id.cough_group)
        // Get radio group selected item using on checked change listener
        coughRadioButton.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            isCoughRadioButtonChecked = radio.text.contentEquals("Yes")
        }

        feverRadioButton = findViewById(R.id.fever_group)
        // Get radio group selected item using on checked change listener
        feverRadioButton.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            isFeverRadioButtonChecked = radio.text.contentEquals("Yes")
        }

        bodypainsRadioButton = findViewById(R.id.bodypains_group)
        // Get radio group selected item using on checked change listener
        bodypainsRadioButton.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            isBodyPainsRadioButtonChecked = radio.text.contentEquals("Yes")
        }

        submit = findViewById(R.id.submitSurvey)

        submit.setOnClickListener() {
            submitSurvey()

        }
    }

    private fun submitSurvey() {
        if (isColdRadioButtonChecked === null || isCoughRadioButtonChecked === null
            || isFeverRadioButtonChecked === null || isBodyPainsRadioButtonChecked === null
        ) {
            val toast = Toast.makeText(
                this, HtmlCompat.fromHtml(
                    "<font color='#FF0000' ><b>Please fill all the questions</b></font>",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                ), Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()


        } else if (isColdRadioButtonChecked === true || isCoughRadioButtonChecked === true ||
            isFeverRadioButtonChecked === true || isBodyPainsRadioButtonChecked === true
        ) {
            val toast = Toast.makeText(
                this, HtmlCompat.fromHtml(
                    "<font color='#FF0000' ><b>You have symptoms of COVID-19, Please take COVID-19 test</b></font>",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                ), Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, CovidTest::class.java)

            startActivity(intent)
        } else {
            val toast = Toast.makeText(
                this, HtmlCompat.fromHtml(
                    "<font color='#00ff00' ><b>Congrats!! You are free from COVID-19</b></font>",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                ), Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
            val intent = Intent(applicationContext, Negative::class.java)

            startActivity(intent)
        }
    }
}