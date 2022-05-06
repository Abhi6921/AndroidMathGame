package com.abhicoder.androidmathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var additionButton : Button
    lateinit var subtractionButton : Button
    lateinit var multiplicationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        additionButton = findViewById(R.id.btnAdd)
        subtractionButton = findViewById(R.id.btnSubtract)
        multiplicationButton = findViewById(R.id.btnMultiply)

        additionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)

        }
    }
}