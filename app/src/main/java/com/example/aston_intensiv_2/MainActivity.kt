package com.example.aston_intensiv_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aston_intensiv_2.lesson_1_1.CodeChallenge1Activity
import com.example.aston_intensiv_2.lesson_1_1.Homework1Activity
import com.example.aston_intensiv_2.lesson_1_2.Homework2Activity
import com.example.aston_intensiv_2.lesson_1_3.Homework3Activity
import com.example.aston_intensiv_2.lesson_2_1.CodeChallenge2Activity
import com.example.aston_intensiv_2.lesson_2_1.Homework4Activity
import com.example.aston_intensiv_2.lesson_2_2.CodeChallenge3Activity
import com.example.aston_intensiv_2.lesson_2_2.Homework5Activity
import com.example.aston_intensiv_2.lesson_2_3.CodeChallenge4Activity
import com.example.aston_intensiv_2.lesson_2_3.Homework6Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCodeChallenge1 = findViewById<Button>(R.id.button_code_challenge_1)
        buttonCodeChallenge1.setOnClickListener { startActivity(Intent(this, CodeChallenge1Activity::class.java)) }

        val buttonHomework1 = findViewById<Button>(R.id.button_homework1)
        buttonHomework1.setOnClickListener { startActivity(Intent(this, Homework1Activity::class.java)) }

        val buttonHomework2 = findViewById<Button>(R.id.button_homework2)
        buttonHomework2.setOnClickListener { startActivity(Intent(this, Homework2Activity::class.java)) }

        val buttonHomework3 = findViewById<Button>(R.id.button_homework3)
        buttonHomework3.setOnClickListener { startActivity(Intent(this, Homework3Activity::class.java)) }

        val buttonCodeChallenge2 = findViewById<Button>(R.id.button_code_challenge_2)
        buttonCodeChallenge2.setOnClickListener { startActivity(Intent(this, CodeChallenge2Activity::class.java)) }

        val buttonHomework4 = findViewById<Button>(R.id.button_homework4)
        buttonHomework4.setOnClickListener { startActivity(Intent(this, Homework4Activity::class.java)) }

        val buttonCodeChallenge3 = findViewById<Button>(R.id.button_code_challenge_3)
        buttonCodeChallenge3.setOnClickListener { startActivity(Intent(this, CodeChallenge3Activity::class.java)) }

        val buttonHomework5 = findViewById<Button>(R.id.button_homework5)
        buttonHomework5.setOnClickListener { startActivity(Intent(this, Homework5Activity::class.java)) }

        val buttonCodeChallenge4 = findViewById<Button>(R.id.button_code_challenge_4)
        buttonCodeChallenge4.setOnClickListener { startActivity(Intent(this, CodeChallenge4Activity::class.java)) }

        val buttonHomework6 = findViewById<Button>(R.id.button_homework6)
        buttonHomework6.setOnClickListener { startActivity(Intent(this, Homework6Activity::class.java)) }
    }
}