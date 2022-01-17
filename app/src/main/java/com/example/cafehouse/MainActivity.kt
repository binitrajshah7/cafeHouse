package com.example.cafehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        title = ""

        setContentView(R.layout.activity_main)
        // removes status bar from the layout
        // imported extra view window and window manager library for this function


        // removes action bar from the activity
        supportActionBar?.hide()

        //signUP activity from main
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val signUpIntent = Intent(this, signUp::class.java)
            startActivity(signUpIntent)
        }

        // signIn activity from main
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val loginIntent = Intent(this, signin::class.java)
            startActivity(loginIntent)
        }
    }
}