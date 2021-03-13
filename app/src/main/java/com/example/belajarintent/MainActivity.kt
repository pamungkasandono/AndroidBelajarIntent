package com.example.belajarintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvHasil: TextView

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_pindah_activity)
        val btnPindahDenganData: Button = findViewById(R.id.btn_pindah_dengan_data)
        val btnPindahDenganObject: Button = findViewById(R.id.btn_pindah_dengan_object)
        val btnDial: Button = findViewById(R.id.btn_dial_number)
        val btnBawaHasil: Button = findViewById(R.id.btn_bawa_hasil)

        btnPindahActivity.setOnClickListener(this)
        btnPindahDenganData.setOnClickListener(this)
        btnPindahDenganObject.setOnClickListener(this)
        btnDial.setOnClickListener(this)
        btnBawaHasil.setOnClickListener(this)

        tvHasil = findViewById(R.id.tv_hasilnya)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pindah_activity -> {
                val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveActivity)
            }
            R.id.btn_pindah_dengan_data -> {
                Intent(this@MainActivity, PindahDenganData::class.java).apply {
                    putExtra(PindahDenganData.EXTRA_NAME, "Pamungkas Andono W" )
                    putExtra(PindahDenganData.EXTRA_AGE, 20)
                    startActivity(this)
                }
            }
            R.id.btn_pindah_dengan_object -> {
                val person = Person(
                    "Pamungkas Andono Warih",
                    21,
                    "pamungkas.org@gmail.com",
                    "Purbalingga"
                )
                Intent(this@MainActivity, MoveWithObject::class.java).apply {
                    putExtra(MoveWithObject.EXTRA_PERSON, person)
                    startActivity(this)
                }
            }
            R.id.btn_dial_number -> {
                val number = "0812345789"
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
            }
            R.id.btn_bawa_hasil -> {
                val moveForRes = Intent(this@MainActivity, MoveForResult::class.java)
                startActivityForResult(moveForRes, REQUEST_CODE)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResult.RES_CODE) {
                val selectedVal = data?.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0)
                tvHasil.text = "Hasil : $selectedVal"
            }
        }
    }
}