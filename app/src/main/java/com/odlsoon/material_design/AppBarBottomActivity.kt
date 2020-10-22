package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_app_bar_bottom.*

class AppBarBottomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_bottom)

        initAppBarBottom()
        initFloatingActionButton()
    }

    private fun initAppBarBottom(){
        bar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.item_bell-> {
                    Toast.makeText(this, "Bell", Toast.LENGTH_SHORT).show()
                }

                R.id.item_clock -> {
                    Toast.makeText(this, "Clock", Toast.LENGTH_SHORT).show()
                }
            }

            true
        }

        bar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Action", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initFloatingActionButton(){
        fab.setOnClickListener {
            Toast.makeText(this, "FAB Action", Toast.LENGTH_SHORT).show()
        }
    }


}
