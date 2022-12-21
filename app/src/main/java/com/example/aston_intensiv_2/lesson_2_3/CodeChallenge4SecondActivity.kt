package com.example.aston_intensiv_2.lesson_2_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * In a previous practical challenge you created a shopping list app builder with an Activity to display the list,
 * and another Activity to pick an item.
 * Add an EditText and a Button to the shopping list Activity to locate a particular store on a map.
 */
class CodeChallenge4SecondActivity : AppCompatActivity() {
    private var shoppingList = ArrayList<String>(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge4_second)

        shoppingList = intent.getStringArrayListExtra(Constants.SHOPPING_ITEMS.name) as ArrayList<String>

        val buttonRice = findViewById<Button>(R.id.button_rice)
        val buttonCheese = findViewById<Button>(R.id.button_cheese)
        val buttonBeef = findViewById<Button>(R.id.button_beef)
        val buttonEggs = findViewById<Button>(R.id.button_eggs)
        val buttonMilk = findViewById<Button>(R.id.button_milk)

        buttonRice.setOnClickListener { onItemSelected(resources.getString(R.string.rice_item)) }
        buttonCheese.setOnClickListener { onItemSelected(resources.getString(R.string.cheese_item)) }
        buttonBeef.setOnClickListener { onItemSelected(resources.getString(R.string.beef_item)) }
        buttonEggs.setOnClickListener { onItemSelected(resources.getString(R.string.eggs_item)) }
        buttonMilk.setOnClickListener { onItemSelected(resources.getString(R.string.milk_item)) }
    }

    private fun onItemSelected(item : String){
        val intent = Intent(this, CodeChallenge4Activity::class.java)

        if(shoppingList.lastIndex == 9) {
            shoppingList.clear()
        }
        shoppingList.add(item)

        intent.putExtra(Constants.SHOPPING_ITEMS.name, shoppingList)
        startActivity(intent)
    }
}