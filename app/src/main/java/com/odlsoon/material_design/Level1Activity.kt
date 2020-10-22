package com.odlsoon.material_design

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_level1.*

class Level1Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

        initComponent()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initComponent(){
        val components = mutableMapOf(
            "App Bar Bottom" to AppBarBottomActivity::class.java,
            "App Bar Top" to AppBarTopActivity::class.java,
            "Bottom Navigation" to BottomNavigationActivity::class.java,
            "Buttons" to ButtonsActivity::class.java,
            "FAB" to FabActivity::class.java,
            "Cards" to CardsActivity::class.java,
            "Chips" to ChipsActivity::class.java,
            "Dialog" to DialogActivity::class.java,
            "Navigation Drawer" to NavigationDrawerActivity::class.java,
            "Pickers" to PickersActivity::class.java,
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
