package com.jatin.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.jatin.customdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAlert.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            var etName=dialog.findViewById<EditText>(R.id.et_name)
            var etCollege=dialog.findViewById<EditText>(R.id.et_college)
            etName.setText(binding.etName.text.toString())
            etCollege.setText(binding.etCollege.text.toString())

            var btnOk=dialog.findViewById<Button>(R.id.btn_ok)
            btnOk.setOnClickListener {
                binding.etName.setText(etName.text.toString())
                binding.etCollege.setText(etCollege.text.toString())
                dialog.dismiss()
            }
        binding.btnClear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Are you sure you want to delte:")
                .setMessage("choose one option")
                .setPositiveButton("yes"){_,_->
                    binding.etName.setText(" ")
                    binding.etCollege.setText(" ")
                    Toast.makeText(this,"Info deleted",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){_,_->
                    Toast.makeText(this,"Info not deleted",Toast.LENGTH_SHORT).show()
                }
                .show()

        }

        }

    }
}
