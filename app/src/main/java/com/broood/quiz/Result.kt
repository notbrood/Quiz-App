package com.broood.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        val CorrectAns = intent.getStringExtra(Constants.correctAnswers)
        val naam = intent.getStringExtra(Constants.USERNAME)
        var tvName = findViewById<TextView>(R.id.namee)
        tvName.text = "$naam"
        val score = findViewById<TextView>(R.id.score)
        score.text = "You scored $CorrectAns out of 5"
        val finish = findViewById<Button>(R.id.Finish)
        finish.setOnClickListener {
            val I = Intent(this, MainActivity::class.java)
            startActivity(I)
        }
    }
}