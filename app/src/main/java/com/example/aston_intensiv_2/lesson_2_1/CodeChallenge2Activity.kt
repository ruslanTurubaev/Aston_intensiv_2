package com.example.aston_intensiv_2.lesson_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
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
class CodeChallenge2Activity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge2)

        val buttonOne = findViewById<Button>(R.id.button_first_text)
        val buttonTwo = findViewById<Button>(R.id.button_second_text)
        val buttonThree = findViewById<Button>(R.id.button_third_text)

        /*
         * The activity itself passes as a click listener
         * the method onClick below
         */
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
    }

    /*
     * Activity itself is a on click listener
     * depends clicked button id param text is set
     * creates an intent, the text puts as extra into that intent
     * and launches the second activity with that intent.
     */
    override fun onClick(view: View?) {
        if(view != null){
            val text = when(view.id){
                R.id.button_first_text -> resources.getString(R.string.article_text)
                R.id.button_second_text -> resources.getString(R.string.article_subtitle)
                else -> resources.getString(R.string.happy_birthday)
            }

            val intent = Intent(this, CodeChallenge2SecondActivity::class.java)
            intent.putExtra(Constants.TEXT.name, text)
            startActivity(intent)
        }
    }
}