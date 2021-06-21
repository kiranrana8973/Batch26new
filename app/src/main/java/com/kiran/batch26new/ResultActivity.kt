package com.kiran.batch26new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResult : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResult = findViewById(R.id.tvResult)

        //Receive values from intent
        val result = intent.getIntExtra("output",0)
        val first = intent.getIntExtra("first",0)
        val second = intent.getIntExtra("second",0)

        tvResult.text = "Sum of $first and $second is $result"

    }
}