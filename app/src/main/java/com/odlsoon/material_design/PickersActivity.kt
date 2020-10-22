package com.odlsoon.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.RangeDateSelector
import com.odlsoon.material_design.utils.DateSplit
import kotlinx.android.synthetic.main.activity_pickers.*
import java.util.*

class PickersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickers)

        initPickers()
    }

    private fun initPickers(){
        button_calendar_date_picker.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
            picker.setTitleText("Date Picker")

            val pickerBuild = picker.build()
            pickerBuild.addOnPositiveButtonClickListener {
                val time = getDateInString(it)

                Log.d("TAG", "${time.dayInMonth} ${time.month} ${time.year} : ${time.hour} ${time.minute} ${time.second}")
            }

            pickerBuild.addOnCancelListener {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            }

            pickerBuild.addOnNegativeButtonClickListener {
                Toast.makeText(this, "Negative Button", Toast.LENGTH_SHORT).show()
            }

            pickerBuild.show(supportFragmentManager, "")
        }

        button_calendar_date_range_picker.setOnClickListener {
            val picker = MaterialDatePicker.Builder.dateRangePicker()
            picker.setTitleText("Date Range Picker")

            val pickerBuild = picker.build()
            pickerBuild.addOnPositiveButtonClickListener {
                val first = getDateInString(it.first!!)
                val second = getDateInString(it.second!!)

                Log.d("TAG", "first -> ${first.dayInMonth} ${first.month} ${first.year} : ${first.hour} ${first.minute} ${first.second}")
                Log.d("TAG", "second -> ${second.dayInMonth} ${second.month} ${second.year} : ${second.hour} ${second.minute} ${second.second}")
            }

            pickerBuild.show(supportFragmentManager, "")
        }
    }

    private fun getDateInString(long: Long): DateSplit {
        val c = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        c.time = Date(long)

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_WEEK)
        val dayInMonth = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)
        val second = c.get(Calendar.SECOND)

        return DateSplit(second, minute, hour, day, dayInMonth, month, year)
    }
}
