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

class signUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        title = ""
        supportActionBar?.hide()

        setContentView(R.layout.activity_sign_up)

        // already have account login from register page
        val haveAccountButton = findViewById<TextView>(R.id.alreadyHaveAccount)
        haveAccountButton.setOnClickListener {
            val loginIntent = Intent(this, signin::class.java)
            startActivity(loginIntent)
        }
    }

    // function runs when we click register button in the signup page
    fun welcomeToast(view: View) {
        val userName = editTextPersonName.editableText.toString()
        Toast.makeText(this,"Welcome $userName", Toast.LENGTH_SHORT).show();
    }
}