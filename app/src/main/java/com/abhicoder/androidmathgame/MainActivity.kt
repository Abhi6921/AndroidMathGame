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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        additionButton = findViewById(R.id.btnAdd)
        subtractionButton = findViewById(R.id.btnSubtract)
        multiplicationButton = findViewById(R.id.btnMultiply)


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
        //vskvnsknvskvn
        multiplicationButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Multiply", "*")
            startActivity(intent)
        }







    }
    /*
            public void onClick(View view) {
        int code;

        switch(view.getId()){
        case R.id.button1:
         code=1;
        break;

        case R.id.button2:
         code=2;
        break;
        }
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("yourcode", code);
            startActivityForResult(i, REQUEST_CODE);
          }
     */

    fun onClick(view : View) {
        var code: Int = 0
        when(view.getId()) {
            R.id.btnAdd -> code = 1
            R.id.btnSubtract -> code = 2
            R.id.btnMultiply -> code = 3
        }

        val intent = Intent(this@MainActivity, GameActivity::class.java)
        intent.putExtra("operator", code)
        startActivity(intent)


    }
}