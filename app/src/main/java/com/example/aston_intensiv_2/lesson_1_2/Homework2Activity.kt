package com.example.aston_intensiv_2.lesson_1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * Open the HelloToast app.
 * Change the name of the project to HelloConstraint, and refactor the project to Hello Constraint.
 * (For instructions on how to copy and refactor a project, see Appendix: Utilities.)
 * Modify the activity_main.xml layout to align the Toast and Count Button elements along the left side of the show_count TextView that shows "0".
 * Include a third Button called Zero that appears between the Toast and Count Button elements.
 * Distribute the Button elements vertically between the top and bottom of the show_count TextView.
 * Set the Zero Button to initially have a gray background.
 * Make sure that you include the Zero Button for the landscape orientation in activity_main.xml (land),
 * and also for a tablet-sized screen in activity_main (xlarge).
 * Make the Zero Button change the value in the show_count TextView to 0.
 * Update the click handler for the Count Button so that it changes its own background color, depending on whether the new count is odd or even.
 *
 * Feel free to to use constants in the Color class for the two different background colors.
 *
 * Update the click handler for the Count Button to set the background color for the Zero Button to something other than gray to show it is now active.
 * Update the click handler for the Zero Button to reset the color to gray, so that it is gray when the count is zero.
 */
class Homework2Activity : AppCompatActivity() {
    private var clickCounter : Int = 0

    private lateinit var buttonCount : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2)

        val buttonToast = findViewById<Button>(R.id.button_toast)
        buttonCount = findViewById(R.id.button_count)
        val buttonZero = findViewById<Button>(R.id.button_zero)
        val textViewShowCount = findViewById<TextView>(R.id.text_view_show_count)

        /*
        * Set saves instance of the activity
        * the main value - the amount of clicks
        * the amount of clicks sets into the textViewShowCount
        * depends on the amount of click set a background color of the buttons zero and count
         */
        if(savedInstanceState != null){
            clickCounter = savedInstanceState.getInt(Constants.COUNT.name)
            textViewShowCount.text = clickCounter.toString()
            if(clickCounter != 0){
                buttonZero.setBackgroundColor(getColor(R.color.pink))
                //Check whether the amount of clicks odd or even and change background color respectively
                setButtonCountBackground()
            }
        }

        buttonToast.setOnClickListener { Toast.makeText(this, R.string.Toast_text, Toast.LENGTH_SHORT).show() }

        /*
        * Handle click on the button zero
        * the amount of clicks is refreshing
        * zero and counts buttons' background color reverts to default values
         */
        buttonZero.setOnClickListener {
            clickCounter = 0
            textViewShowCount.text = clickCounter.toString()
            buttonZero.setBackgroundColor(getColor(R.color.gray))
            buttonCount.setBackgroundColor(getColor(R.color.blue))
        }

        /*
        * Handle click on the button count
        * each click increments the number of clicks
        * the number of clicks represented in textViewShowCount
        * the button changes it background color depends on the amount click,
        * where the amount of clicks is even or odd number
        * the button Zero highlights, if the amount of licks more then 0
         */
        buttonCount.setOnClickListener {
            clickCounter++
            textViewShowCount.text = clickCounter.toString()

            buttonZero.setBackgroundColor(getColor(R.color.pink))
            //Check whether the amount of clicks odd or even and change background color respectively
            setButtonCountBackground()
        }
    }

    /*
    * Handle of the button count background color
    * it changes depends on the amount click,
    * where the amount of clicks is even or odd number
    * the method
     */
    private fun setButtonCountBackground(){
        when(clickCounter % 2){
            0 -> buttonCount.setBackgroundColor(getColor(R.color.green))
            else -> buttonCount.setBackgroundColor(getColor(R.color.blue))
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