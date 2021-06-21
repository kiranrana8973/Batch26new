package com.kiran.batch26new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountryCapitalActivity : AppCompatActivity() {
    private lateinit var countryListview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_capital)

        countryListview = findViewById(R.id.countryListview)

        val countriesCapital = mapOf<String, String>(
            "India" to "New Delhi",
            "Nepal" to "Kathmandu",
            "UK" to "London"
        )
        // create an adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.select_dialog_multichoice,
            countriesCapital.keys.toTypedArray()
        )
        countryListview.adapter = adapter

        countryListview.setOnItemClickListener { parent, view, position, id ->

            val country = parent.getItemAtPosition(position).toString()
            val capital = countriesCapital[country]
            Toast.makeText(
                this, "$country capital is : $capital",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}