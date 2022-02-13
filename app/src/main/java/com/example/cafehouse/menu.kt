package com.example.cafehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {

    companion object{
        const val Name = "NAME_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val name = intent.getStringExtra(Name)
        welcomeGreet.text = "Welcome to Cafe House $name"
    }
}