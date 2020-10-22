package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        initToolbar()
        initNavigationDrawer()
    }

    private fun initToolbar(){
        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
        drawer.addDrawerListener(actionBarDrawerToggle)
    }

    private fun initNavigationDrawer(){
        val itemIds = mutableListOf<Int>()
        itemIds.add(R.id.item_bell)
        itemIds.add(R.id.item_clock)
        itemIds.add(R.id.item_add)
        itemIds.add(R.id.item_bell_menu)
        itemIds.add(R.id.item_clock_menu)
        itemIds.add(R.id.item_add_menu)

        navigation.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_bell -> {
                    Toast.makeText(this, "Bell", Toast.LENGTH_SHORT).show()
                }
                R.id.item_clock -> {
                    Toast.makeText(this, "Clock", Toast.LENGTH_SHORT).show()
                }
                R.id.item_add -> {
                    Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
                }
                R.id.item_bell_menu -> {
                    Toast.makeText(this, "Bell Menu", Toast.LENGTH_SHORT).show()
                }
                R.id.item_clock_menu -> {
                    Toast.makeText(this, "Clock Menu", Toast.LENGTH_SHORT).show()
                }
                R.id.item_add_menu -> {
                    Toast.makeText(this, "Add Menu", Toast.LENGTH_SHORT).show()
                }
            }

            for(i in itemIds){
                navigation.menu.findItem(i).isChecked = false
            }
            it.isChecked = true

            true
        }
    }
}
