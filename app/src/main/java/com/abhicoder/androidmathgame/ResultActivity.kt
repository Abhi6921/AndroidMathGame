package com.abhicoder.androidmathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var scoreResult : TextView
    lateinit var buttonPlayAgain : Button
    lateinit var buttonExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        scoreResult = findViewById(R.id.textViewResult)
        buttonPlayAgain = findViewById(R.id.btnPlayAgain)
        buttonExit = findViewById(R.id.btnExit)

        val score = intent.getIntExtra("score", 0)
        scoreResult.text = "Your Score: " + score

        buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonExit.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}