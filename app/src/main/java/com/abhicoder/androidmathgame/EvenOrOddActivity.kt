package com.abhicoder.androidmathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class EvenOrOddActivity : AppCompatActivity() {

    lateinit var evenOddScore : TextView
    lateinit var evenOddLives : TextView
    lateinit var evenOddNumber : TextView
    lateinit var evenRadioButton : RadioButton
    lateinit var oddRadioButton: RadioButton
    lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_even_or_odd)

        evenOddScore = findViewById(R.id.txtevenOddScore)
        evenOddLives = findViewById(R.id.txtevenOddLivesScore)
        evenOddNumber = findViewById(R.id.textViewNumber)
        evenRadioButton = findViewById(R.id.radioButtonEven)
        oddRadioButton = findViewById(R.id.radioButtonOdd)
        buttonSubmit = findViewById(R.id.btnSubmit)

    }
}