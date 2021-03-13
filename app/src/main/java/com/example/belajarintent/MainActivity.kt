package com.example.belajarintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_pindah_activity)
        val btnPindahDenganData: Button = findViewById(R.id.btn_pindah_dengan_data)
        val btnPindahDenganObject: Button = findViewById(R.id.btn_pindah_dengan_object)

        btnPindahActivity.setOnClickListener(this)
        btnPindahDenganData.setOnClickListener(this)
        btnPindahDenganObject.setOnClickListener(this)
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
        }
    }
}