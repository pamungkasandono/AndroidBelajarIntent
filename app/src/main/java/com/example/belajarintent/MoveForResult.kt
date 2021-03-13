package com.example.belajarintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MoveForResult : AppCompatActivity() {
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_value_ygDipilih"
        const val RES_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        val btnPilih: Button = findViewById(R.id.btn_pilih)
        val rgNumber: RadioGroup = findViewById(R.id.rg_number)

        btnPilih.setOnClickListener {
            if (rgNumber.checkedRadioButtonId > 0) {
                var ygDipilih = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> ygDipilih = 50
                    R.id.rb_100 -> ygDipilih = 100
                    R.id.rb_150 -> ygDipilih = 150
                }
                Intent().apply {
                    putExtra(EXTRA_SELECTED_VALUE, ygDipilih)
                    setResult(RES_CODE, this)
                    finish()
                }
            } else {
                Toast.makeText(this, "Pilih angka diatas terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}