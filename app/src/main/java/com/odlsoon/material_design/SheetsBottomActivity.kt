package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odlsoon.material_design.bottom_sheets.ModalBottomSheet
import kotlinx.android.synthetic.main.activity_sheets_bottom.*

class SheetsBottomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sheets_bottom)

        initBottomSheet()
    }

    private fun initBottomSheet(){
        standard_button.setOnClickListener {
            Toast.makeText(this, "UnFinished....", Toast.LENGTH_SHORT).show()
        }
        modal_button.setOnClickListener {
            ModalBottomSheet().show(supportFragmentManager, "Modal Bottom Sheet")
        }
        expanding_button.setOnClickListener {
            Toast.makeText(this, "Soon....", Toast.LENGTH_SHORT).show()
        }
    }
}
