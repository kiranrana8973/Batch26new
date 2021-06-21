package com.kiran.batch26new

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class DatepickerActivity : AppCompatActivity(){

    private lateinit var spinner: Spinner
    private lateinit var autoCompleteTextview: AutoCompleteTextView
    private lateinit var btnTimePicker: Button
    private lateinit var btnLoadDate: Button
    private lateinit var tvOutput: TextView

    val countries = arrayOf("Nepal", "China", "Japan", "Netherland")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)

        spinner = findViewById(R.id.spinner)
        autoCompleteTextview = findViewById(R.id.autoCompleteTextview)

        btnTimePicker = findViewById(R.id.btnTimePicker)
        btnLoadDate = findViewById(R.id.btnLoadDate)
        tvOutput = findViewById(R.id.tvOutput)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            countries
        )
        spinner.adapter = adapter
        autoCompleteTextview.setAdapter(adapter)
        autoCompleteTextview.threshold = 1

        btnLoadDate.setOnClickListener {
            loadDate()
        }

        btnTimePicker.setOnClickListener {
            loadTime()
        }
    }

    private fun loadTime() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvOutput.text = "$hour : $minute"
            },
            hour,
            minute,
            false
        ).show()
    }


    private fun loadDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                tvOutput.text = "$dayOfMonth - ${month + 1} - $year"
            },
            year,
            month,
            day
        ).show()
    }
}