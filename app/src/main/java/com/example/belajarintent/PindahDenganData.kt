package com.example.belajarintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahDenganData : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_AGE = "age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)

        val tvDataDiterima: TextView = findViewById(R.id.tv_data_diterima)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        tvDataDiterima.text = "Name : $name, Your Age : $age"
    }
}