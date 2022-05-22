package com.abhicoder.androidmathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var additionButton : Button
    lateinit var subtractionButton : Button
    lateinit var multiplicationButton: Button
    lateinit var divisionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        additionButton = findViewById(R.id.btnAdd)
        subtractionButton = findViewById(R.id.btnSubtract)
        multiplicationButton = findViewById(R.id.btnMultiply)
        divisionButton = findViewById(R.id.btnDivision)


        additionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Add", "+")
            startActivity(intent)
        }

        subtractionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Subtract", "-")
            startActivity(intent)
        }

        multiplicationButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Multiply", "*")
            startActivity(intent)
        }

        divisionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Divide", "/")
            startActivity(intent)
        }


    }



}