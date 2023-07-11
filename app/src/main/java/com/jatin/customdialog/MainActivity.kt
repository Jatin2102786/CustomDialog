package com.jatin.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            binding.etName.setText(" ")
            binding.etCollege.setText(" ")
        }

        }

    }
}