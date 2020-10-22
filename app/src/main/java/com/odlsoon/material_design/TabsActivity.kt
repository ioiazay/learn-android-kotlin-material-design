package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odlsoon.material_design.fragment.FragmentAdapter
import com.odlsoon.material_design.fragment.Tab1Fragment
import com.odlsoon.material_design.fragment.Tab2Fragment
import com.odlsoon.material_design.fragment.Tab3Fragment
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        initTabLayout()
    }

    private fun initTabLayout(){
        val adapter = FragmentAdapter(supportFragmentManager)
        adapter.addFragment(Tab1Fragment(), "Tab 1")
        adapter.addFragment(Tab2Fragment(), "Tab 2")
        adapter.addFragment(Tab3Fragment(), "Tab 3")

        viewpager.adapter = adapter
        tab.setupWithViewPager(viewpager)

        val badge1 = tab.getTabAt(0)?.orCreateBadge
        badge1?.isVisible = true
        badge1?.number = 9

        val badge2 = tab.getTabAt(1)?.orCreateBadge
        badge2?.isVisible = true
    }
}
