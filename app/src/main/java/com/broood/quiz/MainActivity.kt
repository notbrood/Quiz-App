package com.broood.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start: Button = findViewById(R.id.start)
        val naam: EditText = findViewById(R.id.naam)
        start.setOnClickListener {
            if(naam.text.isEmpty()){
                Toast.makeText(this, "Enter name!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuizQuestions::class.java)
                intent.putExtra(Constants.USERNAME, naam.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}