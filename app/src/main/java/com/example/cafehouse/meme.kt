package com.example.cafehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_meme.*

class meme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        title = "Meme Page"

        setContentView(R.layout.activity_meme)


//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//        val url = "https://meme-api.herokuapp.com/gimme"
//
//        // Request a string response from the provided URL.
//        val jsonObject = JsonObjectRequest(
//            Request.Method.GET, url, null,
//            Response.Listener { response ->
//                val url = response.getString("url")
//                Glide.with(this).load("url").into(memeImageView)
//            },
//            Response.ErrorListener {
//            })
//
//        // Add the request to the RequestQueue.
//        queue.add(jsonObject)
    }
}