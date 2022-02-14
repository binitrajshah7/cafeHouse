package com.example.cafehouse

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cafehouse.databinding.ActivityHomepageBinding
import com.example.cafehouse.databinding.FragmentButtomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class homepage : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_homepage)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            val snackbar = Snackbar.make(view, "This is Snackbar!", Snackbar.LENGTH_INDEFINITE)

            // setting dismiss button
            snackbar.setAction("Dismiss", View.OnClickListener {

                // alert dialogue opens up when dismiss is clicked
                val alertDialog = AlertDialog.Builder(homepage@ this)

                // title for alert dialogue
                alertDialog.setTitle("Warning from Alert Alert Box")

                // message for alert dialogue
                alertDialog.setMessage("Message From Alert Dialogue")

                // setting positive proceed button
                alertDialog.setPositiveButton(
                    "Proceed",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // setting negative Cancel button
                alertDialog.setNegativeButton(
                    "Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // setting cancellable false for outer space than alert dialogue
                alertDialog.setCancelable(false)

                // showing up alert dialogue
                alertDialog.show()

                // dismissing snackbar when alert dialogue opens up or when dismiss button is clicked
                // in snack bar
                snackbar.dismiss()
            })
                .setActionTextColor(ContextCompat.getColor(this, R.color.purple_200))
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_homepage)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    // bottom sheet from cart 
    fun cartList(view: View) {

        val cartList = buttomSheet()
        cartList.show(supportFragmentManager, "Buttom Sheet Dialogue Tag")
    }

    fun description(view: View) {
        val intent = Intent(this, description :: class.java)
        startActivity(intent)
    }
}