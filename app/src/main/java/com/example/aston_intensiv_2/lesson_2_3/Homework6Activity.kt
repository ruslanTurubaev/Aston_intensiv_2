package com.example.aston_intensiv_2.lesson_2_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ShareCompat
import com.example.aston_intensiv_2.R

/*
 * Open the ImplicitIntents app that you created.
 *
 * Add another button at the bottom of the screen.
 * When the Button is clicked, launch a camera app to take a picture. (You don't need to return the picture to the original app.)
 */
class Homework6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework6)

        /*
         * Start an implicit intent to open an app which can handle a camera
         */
        val buttonOpenCamera = findViewById<Button>(R.id.button_open_camera)
        buttonOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Log.e(this.localClassName, "There is no camera on this device")
            }
        }

        /*
         * Start an implicit intent to open in browser given URL link
         */
        val webSiteEditText = findViewById<EditText>(R.id.edit_text_website)
        val webSiteButton = findViewById<Button>(R.id.button_open_website)

        webSiteButton.setOnClickListener {
            val url = webSiteEditText.text.toString()
            val webpage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Log.e("Implicit Intent", "Can't handle this intent")
            }
        }

        /*
         * Start an implicit intent to find in on-line maps given place for search
         */
        val locationEditText = findViewById<EditText>(R.id.edit_text_location)
        val locationButton = findViewById<Button>(R.id.button_open_location)

        locationButton.setOnClickListener {
            val location = locationEditText.text.toString()
            val loc = Uri.parse("geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, loc)

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Log.e("Implicit Intent", "Can't handle this intent")
            }
        }

        /*
         * Start an implicit intent to send given message in messages
         */
        val shareEditText = findViewById<EditText>(R.id.edit_text_share)
        val shareButton = findViewById<Button>(R.id.button_share_text)

        shareButton.setOnClickListener {
            val text = shareEditText.text
            val minType = "text/plain"

            ShareCompat.IntentBuilder(this)
                .setType(minType)
                .setChooserTitle("Share this text with: ")
                .setText(text).startChooser()
        }
    }
}