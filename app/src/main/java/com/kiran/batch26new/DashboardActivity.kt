package com.kiran.batch26new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DashboardActivity : AppCompatActivity() {

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {

            showAlertDialog()

        }
    }

    private fun showAlertDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mero title")
        builder.setMessage("Are you sure you want to add ?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") { _, _ ->
            val first = etFirst.text.toString().toInt()
            val second = etSecond.text.toString().toInt()
            val result = first + second

            // Open activity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("output", result)
            intent.putExtra("first", first)
            intent.putExtra("second", second)
            startActivity(intent)
        }
        builder.setNegativeButton("No") { _, _ ->
            Toast.makeText(this, "No click bhayo", Toast.LENGTH_SHORT).show()
        }

        val alertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()


    }
}