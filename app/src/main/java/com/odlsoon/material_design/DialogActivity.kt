package com.odlsoon.material_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.odlsoon.material_design.fragment.FullScreenDialogFragment
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        initButtons()
    }

    private fun initButtons(){
        alert_dialog.setOnClickListener {
            showAlertDialog()
        }

        simple_dialog.setOnClickListener {
            showSimpleDialog()
        }

        single_item_conf_dialog.setOnClickListener {
            showSingleItemConfirmationDialog()
        }

        mult_item_conf_dialog.setOnClickListener {
            showMultipleItemConfirmationDialog()
        }

        fullscreen_dialog.setOnClickListener {
            showFullScreenDialog()
        }
    }

    private fun showAlertDialog(){
        MaterialAlertDialogBuilder(this)
            .setTitle("Title")
            .setMessage("Message")
            .setNeutralButton("Neutral"){ dialog, which ->
                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Positive"){dialog, which ->
                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Negative"){dialog, which ->
                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showSimpleDialog(){
        val items = arrayOf("Item 1", "Item 2", "Item 3")

        MaterialAlertDialogBuilder(this)
            .setTitle("String List")
            .setItems(items){dialog, which ->
                Toast.makeText(this, "Which is ${items[which]}", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showSingleItemConfirmationDialog(){
        val items = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItem = 0
        var selectedItem = "Item 1"

        MaterialAlertDialogBuilder(this)
            .setTitle("String List")
            .setPositiveButton("Ok"){dialog, which ->
                Toast.makeText(this, "Ok in $selectedItem", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, which ->
                Toast.makeText(this, "Cancel in $selectedItem", Toast.LENGTH_SHORT).show()
            }
            .setSingleChoiceItems(items, checkedItem){dialog, which ->
                Toast.makeText(this, "Selected item is ${items[which]}", Toast.LENGTH_SHORT).show()
                selectedItem = items[which]
            }
            .show()
    }

    private fun showMultipleItemConfirmationDialog(){
        val items = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItems = booleanArrayOf(false, false, false)
        val selectedItems = mutableListOf<String>()

        MaterialAlertDialogBuilder(this)
            .setTitle("String List")
            .setPositiveButton("Ok"){dialog, which ->
                Toast.makeText(this, "Ok in size ${selectedItems.size}", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, which ->
                Toast.makeText(this, "Cancel in size ${selectedItems.size}}", Toast.LENGTH_SHORT).show()
            }
            .setMultiChoiceItems(items, checkedItems){dialog, which, isChecked ->
                if(isChecked){
                    selectedItems.add(items[which])
                }else{
                    selectedItems.remove(items[which])
                }

                Toast.makeText(this, "Item selected size : ${selectedItems.size}", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showFullScreenDialog(){
        val fullScreenDialogFragment = FullScreenDialogFragment()
        fullScreenDialogFragment.show(supportFragmentManager, "")
    }
}
