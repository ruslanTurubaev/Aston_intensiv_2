package com.example.aston_intensiv_2.lesson_2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * Create an app with a layout that holds a counter TextView, a Button to increment the counter, and an EditText.
 * See the screenshot below as an example. You don't have to precisely duplicate the layout.
 * Add a click handler for the Button that increments the counter.
 * Run the app and increment the counter. Enter some text into the EditText.
 * Rotate the device. Note that the counter is reset, but the EditText is not.
 * Implement onSaveInstanceState() to save the current state of the app.
 * Update onCreate() to restore the state of the app.
 * Make sure that when you rotate the device, the app state is preserved.
 */
class Homework5Activity : AppCompatActivity() {
    private var clickCounter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework5)

        val buttonCount = findViewById<Button>(R.id.button_count_hw5)
        val textViewShowCount = findViewById<TextView>(R.id.text_view_show_count_hw5)

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