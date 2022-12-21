package com.example.aston_intensiv_2.lesson_2_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * Create a simple shopping-list app with a main activity for the list the user is building, and a second activity for a list of common shopping items.
 *
 * The main activity should contain the list to build, which should be made up of ten empty TextView elements.
 * An Add Item button on the main activity launches a second activity that contains a list of common shopping items (Cheese, Rice, Apples, and so on).
 * Use Button elements to display the items.
 * Choosing an item returns the user to the main activity, and updates an empty TextView to include the chosen item.
 * Use an Intent to pass information from one Activity to another.
 * Make sure that the current state of the shopping list is saved when the user rotates the device.
 */
class CodeChallenge3SecondActivity : AppCompatActivity() {
    private var shoppingList = ArrayList<String>(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge3_second)

        //Getting shopping list from the intent
        shoppingList = intent.getStringArrayListExtra(Constants.SHOPPING_ITEMS.name) as ArrayList<String>

        val buttonRice = findViewById<Button>(R.id.button_rice)
        val buttonCheese = findViewById<Button>(R.id.button_cheese)
        val buttonBeef = findViewById<Button>(R.id.button_beef)
        val buttonEggs = findViewById<Button>(R.id.button_eggs)
        val buttonMilk = findViewById<Button>(R.id.button_milk)

        /*
         * Setting the same on click listener
         * each button passes each item which it represent as a param to click handler
         */
        buttonRice.setOnClickListener { onItemSelected(resources.getString(R.string.rice_item)) }
        buttonCheese.setOnClickListener { onItemSelected(resources.getString(R.string.cheese_item)) }
        buttonBeef.setOnClickListener { onItemSelected(resources.getString(R.string.beef_item)) }
        buttonEggs.setOnClickListener { onItemSelected(resources.getString(R.string.eggs_item)) }
        buttonMilk.setOnClickListener { onItemSelected(resources.getString(R.string.milk_item)) }
    }

    /*
     * Handle click on each button
     * @param - string item to be added to the shopping list
     *
     * checks whether shopping list is full
     * if yes, clear it
     * taking into account that on the parent activity we have only 10 texView,
     * we can represent only 10 items
     * if shopping list is already full (has records about 10 items),
     * we can either ignore overfill or star shopping list from the begging
     * in order to processed have been chosen the second option
     *
     * put renew shopping list as extra to the intent
     * launches the parent activity with that intent
     */
    private fun onItemSelected(item : String){
        val intent = Intent(this, CodeChallenge3Activity::class.java)

        if(shoppingList.lastIndex == 9) {
            shoppingList.clear()
        }
        shoppingList.add(item)

        intent.putExtra(Constants.SHOPPING_ITEMS.name, shoppingList)
        startActivity(intent)
    }
}