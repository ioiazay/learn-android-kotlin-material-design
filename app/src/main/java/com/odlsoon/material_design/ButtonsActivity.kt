package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_buttons.*

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        initButtons()
    }

    private fun initButtons(){
        button_text.setOnClickListener {
            Toast.makeText(this, "Text Button", Toast.LENGTH_SHORT).show()
        }

        button_outlined.setOnClickListener {
            Toast.makeText(this, "Outlined Button", Toast.LENGTH_SHORT).show()
        }

        button_outlined_icon.setOnClickListener {
            Toast.makeText(this, "Outlined Button Icon", Toast.LENGTH_SHORT).show()
        }

        button_contained.setOnClickListener {
            Toast.makeText(this, "Contained Button", Toast.LENGTH_SHORT).show()
        }

        button_contained_icon.setOnClickListener {
            Toast.makeText(this, "Contained Button Icon", Toast.LENGTH_SHORT).show()
        }

        button_unelevated.setOnClickListener {
            Toast.makeText(this, "Unelevated Button", Toast.LENGTH_SHORT).show()
        }

        button_1.setOnClickListener {
            Toast.makeText(this, "Button 1", Toast.LENGTH_SHORT).show()
        }

        button_2.setOnClickListener {
            Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show()
        }

        button_3.setOnClickListener {
            Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show()
        }
    }
}
