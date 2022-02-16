package com.example.cafehouse

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_meme.*

class meme : AppCompatActivity() {
    lateinit var memeUrl: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        title = "Meme Page"

        setContentView(R.layout.activity_meme)
        loadMeme()

        nextBtn.setOnClickListener(){
            loadMeme()
        }

        shareBtn.setOnClickListener(){
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, memeUrl)
            val chooser = Intent.createChooser(share,"Share Via")
            startActivity(chooser)
        }
    }

    fun loadMeme(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObject = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
               memeUrl = response.getString("url")
                Glide.with(this).load(memeUrl).listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                }).into(memeImageView)
            },
            {
                Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show()
            })

        // Add the request to the RequestQueue.
        queue.add(jsonObject)
    }
}