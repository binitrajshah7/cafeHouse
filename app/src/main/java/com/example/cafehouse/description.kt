package com.example.cafehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafehouse.databinding.ActivityDescriptionBinding

class description : AppCompatActivity() {

    lateinit var binding: ActivityDescriptionBinding
    lateinit var descriptionList : ArrayList<titleAndDescription>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = arrayOf(
            "Splash Screen",
            "Landing Page",
            "Login",
            "SignIn",
            "Floating action Button Message",
            "Floating action button Cart list",
            "SignUp",
            "Register",
            "Meme Here",
            "Reach Us",
            "Social Media"
        )

        val description = arrayOf(
            "1) Used Splash screen animation using two animation resource file. \n " +
                    "2) Top Animation animates App logo from Top. \n" +
                    "3) Bottom Animation animates App headline from bottom.",
            "Landing Page Consists several button for Different functionalities",
            "Login Button takes us to login page",
            "Provide necessary login credentials in and signIn to get in main page",
            "The parent layout of this button is coordinator layout that means each view changes in coordinate with other views\n" +
                    "This button shows up snack bar with indefinite length having a dismiss button\n" +
                    "on clicking dismiss button a alert dialogue pops up with a positive button and negative button\n" +
                    "Used default alert dialogue box from android studio we can calibrate it with xml files too",

            "This button shows up bottom sheet having all items in the shopping cart\n" +
                    "Used Fragment to show bottom sheet fragment that extends BottomSheetFragment class",

            "Helps landing to the signup page",

            "Register button calls an intent which sends data user name to next landing page with a welcome message to the user with provided name",

            "Meme here opens up a activity where we call meme from an API call more work to this is pending",

            "Reach us uses explicit intent call where we send data cross applications and do some task in new opened app",

            "Connecting user to social media handle of the App (Pending Task)"
            )


        descriptionList = ArrayList()

        for (i in title.indices)
        {
            val titleAndDescription = titleAndDescription(title[i], description[i])
            descriptionList.add(titleAndDescription)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.descriptionRecycler.layoutManager = layoutManager

        val adapter = descriptionAdapter(this, descriptionList)
        binding.descriptionRecycler.adapter = adapter
    }
}