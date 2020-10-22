package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_chips.*

class ChipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chips)

        initChips()
    }

    private fun initChips(){
        var singleChip: Chip? = null
        val multipleCips = mutableListOf<Chip>()

        chip_action.setOnClickListener {
            Toast.makeText(this, "Chip Action", Toast.LENGTH_SHORT).show()
        }

        chip_entry.setOnCloseIconClickListener {
            Toast.makeText(this, "Close Action", Toast.LENGTH_SHORT).show()
        }

        chip_filter.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "$isChecked", Toast.LENGTH_SHORT).show()
        }

        chip_group_single.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            singleChip = chip

            Toast.makeText(this, "Chip Title : ${singleChip?.text.toString()}", Toast.LENGTH_SHORT).show()
        }

        /**
         * Chip Group tidak berfungsi untuk multiple selected
         * fungsi setOnCheckedChangeListener tidak terpanggil
         */
        chip_group_multiple.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)

            if(checkedId == -1){
                multipleCips.remove(chip)
            }else{
                multipleCips.add(chip)
            }

            Toast.makeText(this, "Chips Size : ${multipleCips.size}", Toast.LENGTH_SHORT).show()
        }
    }
}
