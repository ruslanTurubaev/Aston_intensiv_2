package com.example.aston_intensiv_2.lesson_2_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * Pasha, sorry for this shit code, there are better solutions here but I tried to be in compliance with a task
 *
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
class CodeChallenge3Activity : AppCompatActivity() {

    private lateinit var tv1 : TextView
    private lateinit var tv2 : TextView
    private lateinit var tv3 : TextView
    private lateinit var tv4 : TextView
    private lateinit var tv5 : TextView
    private lateinit var tv6 : TextView
    private lateinit var tv7 : TextView
    private lateinit var tv8 : TextView
    private lateinit var tv9 : TextView
    private lateinit var tv10 : TextView

    private var shoppingList = ArrayList<String>(10)
    private var textViews = ArrayList<TextView>(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge3)

        init()

        /*
         * Getting shopping list, it may be either in Bundle or in intent from the child activity
         * in other cases intent came from MainActivity and the shopping list is empty
         */
        if(savedInstanceState != null){
            //Getting shopping list from saveInstance
            shoppingList = savedInstanceState.getStringArrayList(Constants.SHOPPING_CONSTANTS.name) as ArrayList<String>
            //set items from the shopping list to the text views
            setShoppingList()
        }
        else{
            //Getting shopping list from instance received from the child activity
            val tempList = intent.getStringArrayListExtra(Constants.SHOPPING_ITEMS.name)

            /*
             * If the tempList is null that means the intent came from the MainActivity, shopping list should be empty
             * If the tempList is not null that means that the intent came from the child activity, shopping list should reset
             */
            if(tempList != null) {
                shoppingList = tempList
                //set items from the shopping list to the text views
                setShoppingList()
            }
        }

        /*
         * Handle click on the button Add Item
         * creates an intent, the current state of shopping list puts as extra into that intent
         * and launches the second activity with that intent.
         */
        val buttonAddItem = findViewById<Button>(R.id.button_add_items_to_shopping_list)
        buttonAddItem.setOnClickListener {
            val intent = Intent(this, CodeChallenge3SecondActivity::class.java)
            intent.putExtra(Constants.SHOPPING_ITEMS.name, shoppingList)
            startActivity(intent)
        }
    }

    /*
     * Initialization of all textViews
     * each texView puts into an arrayList in order to simplify handling them
     */
    private fun init(){
        tv1 = findViewById(R.id.text_view_shopping_list_1)
        tv2 = findViewById(R.id.text_view_shopping_list_2)
        tv3 = findViewById(R.id.text_view_shopping_list_3)
        tv4 = findViewById(R.id.text_view_shopping_list_4)
        tv5 = findViewById(R.id.text_view_shopping_list_5)
        tv6 = findViewById(R.id.text_view_shopping_list_6)
        tv7 = findViewById(R.id.text_view_shopping_list_7)
        tv8 = findViewById(R.id.text_view_shopping_list_8)
        tv9 = findViewById(R.id.text_view_shopping_list_9)
        tv10 = findViewById(R.id.text_view_shopping_list_10)

        textViews.add(tv1)
        textViews.add(tv2)
        textViews.add(tv3)
        textViews.add(tv4)
        textViews.add(tv5)
        textViews.add(tv6)
        textViews.add(tv7)
        textViews.add(tv8)
        textViews.add(tv9)
        textViews.add(tv10)
    }

    /*
     * Shopping list setter
     * iterating shopping list and set items into the corresponding textView
     */
    private fun setShoppingList(){
        for ( (index, item) in shoppingList.withIndex() ){
            textViews[index].text = item
        }
    }

    /*
     * Saving current instance of the activity
     * clearing shopping list in order to avoid overfill
     * iterating list with the textViews and put there text param into the shopping list, if it is not empty
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        shoppingList.clear()

        textViews.forEach {
            if(it.text.toString() != "") {
                shoppingList.add(it.text.toString())
            }
        }

        outState.putStringArrayList(Constants.SHOPPING_CONSTANTS.name, shoppingList)
    }
}