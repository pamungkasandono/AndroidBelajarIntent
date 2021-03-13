package com.example.belajarintent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObject : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_object_person"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObjectDiterima: TextView = findViewById(R.id.tv_object_diterima)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        tvObjectDiterima.text = "Nama : ${person.name.toString()}, \nEmail : ${person.email}, \nAge : ${person.age.toString()}, \nCity : ${person.city.toString()}"
    }
}