package com.example.cafehouse

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_meme.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
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

        // meme button
        memeButton.setOnClickListener{
            val memePage = Intent(this, meme::class.java)
            startActivity(memePage)
        }

        // mail button
        mailBtn.setOnClickListener{
            val email = "mailSupport@cafeHouse.com"
            val i = Intent();
            i.action = Intent.ACTION_SENDTO
            i.data = Uri.parse("mailto:$email")
            startActivity(i)
        }

        // browse button
        browseBtn.setOnClickListener{
            val address = "cafehouse.com"
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("http://$address")
            startActivity(i)
        }

        // dial button
        dialBtn.setOnClickListener{
            val number = "7645892047"
            val i = Intent()
            i.action = Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$number")
            startActivity(i)
        }

    }
}