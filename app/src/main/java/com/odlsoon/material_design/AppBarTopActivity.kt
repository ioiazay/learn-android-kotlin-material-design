package com.odlsoon.material_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_app_bar_top.*

class AppBarTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_top)

        initappBarTop()
        initComponent()
    }

    private fun initappBarTop(){
        setSupportActionBar(topAppBar)
        supportActionBar?.title = "App Bar Top"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
            var isShow = true
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout?.totalScrollRange!!
                }

                if (scrollRange + verticalOffset == 0) {
                    collapsing_toolbar.title = "App Bar Top"
                    isShow = true
                } else if(isShow) {
                    collapsing_toolbar.title = " "
                    isShow = false
                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbartop_menu, menu)

        val imageViewBell = menu?.findItem(R.id.item_bell)?.actionView as ImageView
        imageViewBell.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bell))
        imageViewBell.setOnClickListener {
            Toast.makeText(this, "Bell", Toast.LENGTH_SHORT).show()
        }

        val imageViewClock = menu.findItem(R.id.item_clock).actionView as ImageView
        imageViewClock.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.clock))
        imageViewClock.setPadding(32, 0, 0, 0)
        imageViewClock.setOnClickListener {
            Toast.makeText(this, "Clock", Toast.LENGTH_SHORT).show()
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_more->{
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }

    private fun initComponent(){
        val components = mutableMapOf(
            "App Bar Bottom" to AppBarBottomActivity::class.java,
            "Bottom Navigation" to BottomNavigationActivity::class.java,
            "Buttons" to ButtonsActivity::class.java,
            "FAB" to FabActivity::class.java,
            "Cards" to CardsActivity::class.java,
            "Chips" to ChipsActivity::class.java,
            "Dialog" to DialogActivity::class.java,
            "Navigation Drawer" to NavigationDrawerActivity::class.java,
            "Selection Controls" to SelectionControlsActivity::class.java,
            "Sheets Bottom" to SheetsBottomActivity::class.java,
            "Slider" to SliderActivity::class.java,
            "Snackbars" to SnackbarsActivity::class.java,
            "Tabs" to TabsActivity::class.java,
            "Text Fields" to TextFieldsActivity::class.java
        )

        components.forEach {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            val button = MaterialButton(this, null, R.attr.materialButtonStyle)

            params.setMargins(16, 16, 16, 16)
            button.layoutParams = params
            button.text = it.key
            button.setOnClickListener {v ->
                startActivity(Intent(this, it.value))
            }

            ll_main.addView(button)
        }
    }
}
