package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_text_fields.*

class TextFieldsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_fields)

        initInputFields()
    }

    private fun initInputFields(){
        val strings = mutableListOf<String>()
        strings.add("Item 1")
        strings.add("Item 2")
        strings.add("Item 3")
        strings.add("Item 4")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strings)
        autocomplete.setAdapter(adapter)

        textinput.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Do something
            }
        })
    }
}
