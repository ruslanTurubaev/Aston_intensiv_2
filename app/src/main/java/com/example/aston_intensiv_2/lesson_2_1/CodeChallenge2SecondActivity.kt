package com.example.aston_intensiv_2.lesson_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * Create an app with three Button elements labeled Text One, Text Two, and Text Three.
 * When any of these Button elements are clicked, launch a second Activity.
 * That second Activity should contain a ScrollView that displays one of three text passages
 * (you can include your choice of passages).
 * Use an Intent to launch the second Activity with extras to indicate which of the three passages to display.
 */
class CodeChallenge2SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge2_second)

        val textViewPassedText = findViewById<TextView>(R.id.text_view_passed_text)
        val text = intent.getStringExtra(Constants.TEXT.name)

        textViewPassedText.text = text
    }
}