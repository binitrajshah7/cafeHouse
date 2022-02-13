package com.example.cafehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_signin.*

class signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        title = ""
        supportActionBar?.hide()

        setContentView(R.layout.activity_signin)

        // already have account login from register page
        val accountFromSignIn = findViewById<TextView>(R.id.accountFromSignIn)
        accountFromSignIn.setOnClickListener {
            val signUpIntent = Intent(this, signUp::class.java)
            startActivity(signUpIntent)
        }

    }

    // function runs when we click register button in the signup page
    fun homepage(view: View) {
        Toast.makeText(this,"Welcome to home page", Toast.LENGTH_SHORT).show();
        // intent to open up menu page after hitting register
        val intent = Intent(this, homepage :: class.java)
        startActivity(intent)
    }
}