package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_selection_controls.*

class SelectionControlsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_controls)

        initCheckboxs()
        initRadios()
        initSwitcher()
    }

    private fun initCheckboxs(){
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this, "status : $isChecked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRadios(){
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            val radio = group.findViewById<RadioButton>(checkedId)
            Toast.makeText(this, "status : ${radio.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initSwitcher(){
        switch_widget.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this, "status : $isChecked", Toast.LENGTH_SHORT).show()
        }
    }
}
