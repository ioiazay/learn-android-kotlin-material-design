package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        initBottomNavigation()
        initBadge()
    }

    private fun initBottomNavigation(){
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item_bell->{
                    Log.d("TAG", "Bell")
                }
                R.id.item_add->{
                    Log.d("TAG", "Add")
                }
                R.id.item_clock->{
                    Log.d("TAG", "Clock")
                }
            }

            true
        }
    }

    private fun initBadge(){
        val badgeBell = bottom_navigation.getOrCreateBadge(R.id.item_bell)
        badgeBell.isVisible = true

        val badgeAdd = bottom_navigation.getOrCreateBadge(R.id.item_add)
        badgeAdd.isVisible = true
        badgeAdd.number = 15

        val badgeClock = bottom_navigation.getOrCreateBadge(R.id.item_clock)
        badgeClock.isVisible = true
        badgeClock.maxCharacterCount = 3
        badgeClock.number = 100
    }
}
