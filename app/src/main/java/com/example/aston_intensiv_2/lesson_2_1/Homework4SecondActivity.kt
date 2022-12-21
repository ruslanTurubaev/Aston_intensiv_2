package com.example.aston_intensiv_2.lesson_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * Open the HelloToast app that you created in a previous practical codelab.
 *
 * Modify the Toast button so that it launches a new Activity to display the word "Hello!" and the current count, as shown below.
 * Change the text on the Toast button to Say Hello.
 */
class Homework4SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework4_second)

        val textViewClicksAmount = findViewById<TextView>(R.id.text_view_clicks_amount)

        //Get data from intent and set it into the textViewClicksAmount
        val clicksAmount = intent.getIntExtra(Constants.COUNT.name, 0)
        textViewClicksAmount.text = clicksAmount.toString()
    }
}