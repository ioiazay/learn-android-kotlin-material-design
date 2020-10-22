package com.odlsoon.material_design

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLevel()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initLevel(){
        val components = mutableMapOf(
            "Level 1" to Level1Activity::class.java,
            "Level 2" to Level2Activity::class.java,
            "Theming" to ThemingActivity::class.java
        )

        components.forEach {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            val button = MaterialButton(this, null, R.attr.materialButtonStyle)

            params.setMargins(16, 16, 16, 16)
            button.layoutParams = params
            button.text = it.key
            button.setOnClickListener {v ->
                if(it.key == "Level 1"){
                    startActivity(Intent(this, it.value))
                }else{
                    Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
                }
            }

            ll_main.addView(button)
        }
    }
}
