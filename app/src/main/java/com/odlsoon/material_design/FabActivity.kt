package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fab.*

class FabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab)

        initFAB()
    }

    private fun initFAB(){
        fab.setOnClickListener {
            Toast.makeText(this, "FAB Action", Toast.LENGTH_SHORT).show()
        }

        ex_fab.setOnClickListener {
            Toast.makeText(this, "Extended FAB Action", Toast.LENGTH_SHORT).show()
        }
    }
}
