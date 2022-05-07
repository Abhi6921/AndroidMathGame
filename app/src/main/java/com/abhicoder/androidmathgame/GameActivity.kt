package com.abhicoder.androidmathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var textQuestion : TextView
    lateinit var textAnswer : EditText

    lateinit var buttonOK : Button
    lateinit var buttonNext : Button

    var correctAnswer : Int = 0
    var userScore : Int = 0
    var userLife : Int = 3

    // timer
    lateinit var timer : CountDownTimer
    private val startTimerInMills : Long = 20000
    var timeLeftInMillis : Long = startTimerInMills
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)

        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextAnswer)

        buttonOK = findViewById(R.id.btnOK)
        buttonNext = findViewById(R.id.btnNext)

        gameContineue()

        buttonOK.setOnClickListener {
            val answer = textAnswer.text.toString()
            if (answer == "") {
                Toast.makeText(applicationContext, "Please write an answer or click on next", Toast.LENGTH_LONG).show()
            }
            else {
                pauseTimer()
                val userAnswer = answer.toInt()
                // check if user ans is correct

                if (userAnswer == correctAnswer) {
                    userScore += 10
                    textQuestion.text = "Correct!, :)"
                    textScore.text = userScore.toString()
                }
                else {
                    userLife -= 1
                    textQuestion.text = "Wrong answer! :("
                    textLife.text = userLife.toString()

                }
            }
        }

        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()
            gameContineue()
            textAnswer.setText("")

            if (userLife == 0) {
                Toast.makeText(applicationContext, "Game Over", Toast.LENGTH_LONG).show()
                val intent = Intent(this@GameActivity, ResultActivity::class.java)
                intent.putExtra("score", userScore)
                startActivity(intent)
                finish()
            }
            else {
                gameContineue()
            }
        }
    }

    fun gameContineue() {
        // get random numbers
        val number1: Int = Random.nextInt(0, 100)
        val number2: Int = Random.nextInt(0, 100)

        // write numbers on textview
        textQuestion.text = "$number1 + $number2"
        correctAnswer = number1 + number2

        startTimer()
    }

    fun startTimer() {

        timer = object : CountDownTimer(timeLeftInMillis, 1000) {

            
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                // reset timer when finished
                resetTimer()
                // update time when finished
                updateText()

                userLife -= 1

                textLife.text = userLife.toString()
                textQuestion.text = "Sorry! your time is up"


            }

        }.start()
    }

    fun updateText() {
        val remainingTime : Int = (timeLeftInMillis / 1000).toInt()
        textTime.text = String.format(Locale.getDefault(), "%2d", remainingTime)
    }

    fun pauseTimer() {
        timer.cancel()
    }

    fun resetTimer() {
        timeLeftInMillis = startTimerInMills;
        updateText()
    }

}