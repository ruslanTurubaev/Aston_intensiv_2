package com.example.aston_intensiv_2.lesson_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aston_intensiv_2.R

/*
 * TASK:
 * Create a new Android project from the Empty Activity Template.
 * Add logging statements for various log levels in onCreate() in the main activity.
 * Create an emulator for a device, targeting any version of Android you like, and run the app.
 * Use filtering in Logcat to find your log statements and adjust the levels to only display debug or error logging statements.
 */
class Homework1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1)

        Log.d(this.localClassName, "Debug")
        Log.e(this.localClassName, "Errors")
    }
}