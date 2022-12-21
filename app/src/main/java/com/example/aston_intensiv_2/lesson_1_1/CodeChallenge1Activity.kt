package com.example.aston_intensiv_2.lesson_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aston_intensiv_2.R

/*
 * TASK:
 * Create a new project in Android Studio.
 * Change the "Hello World" greeting to "Happy Birthday to " and the name of someone with a recent birthday.
 * (Optional) Take a screenshot of your finished app and email it to someone whose birthday you forgot.
 * A common use of the Log class is to log Java exceptions when they occur in your program.
 * There are some useful methods, such as Log.e(), that you can use for this purpose.
 * Explore methods you can use to include an exception with a Log message.
 * Then, write code in your app to trigger and log an exception.
 */
class CodeChallenge1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_challenge1)

        try {
            throw java.lang.IllegalArgumentException()
        }
        catch (exception : IllegalArgumentException){
            Log.e("CodeChallenge1Activity", "Exception caught")
        }
    }
}