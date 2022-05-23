package com.abhicoder.androidmathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import kotlin.random.Random

class EvenOrOddActivity : AppCompatActivity() {

    lateinit var evenOddScore : TextView
    lateinit var evenOddLives : TextView
    lateinit var evenOddNumber : TextView
    lateinit var evenRadioButton : RadioButton
    lateinit var oddRadioButton: RadioButton
    lateinit var buttonSubmit: Button
    lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_even_or_odd)

        evenOddScore = findViewById(R.id.txtevenOddScore)
        evenOddLives = findViewById(R.id.txtevenOddLivesScore)
        evenOddNumber = findViewById(R.id.textViewNumber)
        evenRadioButton = findViewById(R.id.radioButtonEven)
        oddRadioButton = findViewById(R.id.radioButtonOdd)
        buttonSubmit = findViewById(R.id.btnSubmit)
        buttonNext = findViewById(R.id.btnForward)

        var randomNumber = Random.nextInt(0, 20)
        evenOddNumber.text = randomNumber.toString()
        buttonNext.setEnabled(false)

        buttonSubmit.setOnClickListener {
            if (randomNumber % 2 == 0) {
                if (evenRadioButton.isChecked()) {
                    evenOddNumber.setText("Correct :)")

                }
                else if(oddRadioButton.isChecked()) {
                    evenOddNumber.setText("InCorrect :(")
                }
                buttonNext.setEnabled(true)
            }
            else {
                if (oddRadioButton.isChecked()) {
                    evenOddNumber.setText("Correct :)")
                }
                else if(evenRadioButton.isChecked()) {
                    evenOddNumber.setText("InCorrect :(")
                }
                buttonNext.setEnabled(true)
            }
        }

        buttonNext.setOnClickListener {
            randomNumber = Random.nextInt(0, 20)
            evenOddNumber.text = randomNumber.toString()
        }
    }




}