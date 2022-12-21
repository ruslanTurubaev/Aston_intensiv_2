package com.example.aston_intensiv_2.lesson_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
class Homework4Activity : AppCompatActivity() {
    private var clickCounter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework4)

        val buttonSend = findViewById<Button>(R.id.button_send)
        val buttonCount = findViewById<Button>(R.id.button_count)
        val textViewShowCount = findViewById<TextView>(R.id.text_view_show_count)

        /*
         * Set saves instance of the activity
         * the main value - the amount of clicks
         * the amount of clicks sets into the textViewShowCount
         */
        if(savedInstanceState != null){
            clickCounter = savedInstanceState.getInt(Constants.COUNT.name)
            textViewShowCount.text = clickCounter.toString()
        }

        /*
         * Handle click on the button count
         * each click increments the number of clicks
         * the number of clicks represented in textViewShowCount
         */
        buttonCount.setOnClickListener {
            clickCounter++
            textViewShowCount.text = clickCounter.toString()
        }

        /*
         * Handle click on the button send
         * creates an intent, the amount of clicks puts as extra into that intent
         * and launches the second activity with that intent.
         */
        buttonSend.setOnClickListener {
            val intent = Intent(this, Homework4SecondActivity::class.java)
            intent.putExtra(Constants.COUNT.name, clickCounter)
            startActivity(intent)
        }
    }

    /*
     * Save instance of the activity
     * saved param - the amount of clicks
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.COUNT.name, clickCounter)
    }
}