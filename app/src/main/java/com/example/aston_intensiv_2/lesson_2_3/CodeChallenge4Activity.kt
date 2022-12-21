package com.example.aston_intensiv_2.lesson_2_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.utils.Constants

/*
 * TASK:
 * In a previous practical challenge you created a shopping list app builder with an Activity to display the list,
 * and another Activity to pick an item.
 * Add an EditText and a Button to the shopping list Activity to locate a particular store on a map.
 */
class CodeChallenge4Activity : AppCompatActivity() {
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
        setContentView(R.layout.activity_code_challenge4)

        /*
         * Start an implicit intent to find in on-line maps given place for search
         */
        val editTextStoreName = findViewById<EditText>(R.id.edit_text_store_name)
        val buttonFindStore = findViewById<Button>(R.id.button_find_store)

        /*
         * Handle click on the button find store
         * get information about store from editTextStoreName
         * pass it as a URI into the implicit intent
         * start the intent, if there is an app which can handle it
         */
        buttonFindStore.setOnClickListener {
            val storeName = editTextStoreName.text.toString()
            val storeLocation = Uri.parse("geo:0,0?q=$storeName")
            val intent = Intent(Intent.ACTION_VIEW, storeLocation)

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Log.e(this.localClassName, "Can't handle this intent")
            }
        }

        init()

        if(savedInstanceState != null){
            shoppingList = savedInstanceState.getStringArrayList(Constants.SHOPPING_CONSTANTS.name) as ArrayList<String>
            setShoppingList()
        }
        else{
            val tempList = intent.getStringArrayListExtra(Constants.SHOPPING_ITEMS.name)

            if(tempList != null) {
                shoppingList = tempList
                setShoppingList()
            }
        }

        val buttonAddItem = findViewById<Button>(R.id.button_add_items_to_shopping_list)
        buttonAddItem.setOnClickListener {
            val intent = Intent(this, CodeChallenge4SecondActivity::class.java)
            intent.putExtra(Constants.SHOPPING_ITEMS.name, shoppingList)
            startActivity(intent)
        }
    }

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

    private fun setShoppingList(){
        for ( (index, item) in shoppingList.withIndex() ){
            textViews[index].text = item
        }
    }

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