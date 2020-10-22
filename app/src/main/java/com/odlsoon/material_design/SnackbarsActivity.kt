package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_snackbars.*

class SnackbarsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbars)

        initSnackbars()
    }

    private fun initSnackbars(){
        button_snackbar.setOnClickListener {
            Snackbar.make(coordinator, "Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        button_snackbar_action.setOnClickListener {
            Snackbar.make(coordinator, "Snackbar Action", Snackbar.LENGTH_LONG)
                .setAction(
                    "Refresh",
                    View.OnClickListener {
                        Toast.makeText(this, "Refresh Action", Toast.LENGTH_SHORT).show()
                    }
                )
                .show()
        }

        button_snackbar_indefinity.setOnClickListener {
            Snackbar.make(coordinator, "Snackbar Indefinity", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close",
                View.OnClickListener {
                    it.visibility = View.GONE
                })
                .show()
        }
    }
}
