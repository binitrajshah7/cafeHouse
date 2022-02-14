package com.example.cafehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.cafehouse.databinding.ActivityDescriptionBinding

class description : AppCompatActivity() {

    lateinit var binding : ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }
}