package com.abhicoder.androidmathgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
    private val startTimerInMills : Long = 60000
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
        buttonNext.setEnabled(false)

        buttonOK.setOnClickListener {
            val answer = textAnswer.text.toString()
            if (answer == "") {
                Toast.makeText(applicationContext, "Please write an answer or click on next", Toast.LENGTH_LONG).show()
                buttonNext.setEnabled(false);
            }
            else {
                pauseTimer()
                val userAnswer = answer.toInt()
                // check if user ans is correct

                if (userAnswer == correctAnswer) {
                    userScore += 10
                    textQuestion.text = "Correct!, :)"
                    textScore.text = userScore.toString()
                    buttonNext.setEnabled(true)
                }
                else {
                    userLife -= 1
                    textQuestion.text = "Wrong answer! :("
                    textLife.text = userLife.toString()
                    buttonNext.setEnabled(true)
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
                buttonNext.setEnabled(false);
            }
        }
    }

    fun gameContineue() {
        // get random numbers
        val number1: Int = Random.nextInt(0, 10)
        val number2: Int = Random.nextInt(0, 10)

        val add: String = getIntent().getStringExtra("Add").toString()
        val subtract: String = getIntent().getStringExtra("Subtract").toString()
        val multiply: String = getIntent().getStringExtra("Multiply").toString()
        val divide: String = getIntent().getStringExtra("Divide").toString()

        if (add == "+") {
            // write numbers on textview
            textQuestion.text = "$number1 + $number2"
            correctAnswer = number1 + number2
            startTimer()
        }
        if (subtract == "-") {
            textQuestion.text = "$number1 - $number2"
            correctAnswer = number1 - number2
            startTimer()
        }

        if (multiply == "*") {
            textQuestion.text = "$number1 * $number2"
            correctAnswer = number1 * number2
            startTimer()
        }

        if(divide == "/") {

            val first = (Math.random() * 100 + 1).toInt()
            val firstNumDivisors = getDivisors(first)

            val divisorsRandIndex = (Math.random() * firstNumDivisors!!.size).toInt()
            val second = firstNumDivisors!![divisorsRandIndex]
            var question : String? = null

            if (first % second == 0 && first > second) {
                question = "$first / $second"
                textQuestion.setText(question)
                correctAnswer = (first / second).toInt();
            }
             if (second % first == 0 && second > first) {
                question = "$second / $first"
                textQuestion.setText(question)
                correctAnswer = (second / first).toInt();
            }
        }

    }

    private fun getDivisors(number: Int): List<Int>? {
        val divisors: MutableList<Int> = ArrayList()
        for (i in 1..number) if (number % i == 0) divisors.add(i)
        return divisors
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