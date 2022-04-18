package com.broood.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.Exception
import java.util.ArrayList

class QuizQuestions : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var tvProg: TextView? = null
    private var tvQuestion: TextView? = null
    private var temp = 0
    private var op1: TextView? = null
    private var op2: TextView? = null
    private var op3: TextView? = null
    private var op4: TextView? = null
    private var selectedButton: TextView? = null
    private var truHaiKya: Boolean = false
    private var currentPosition = 0
    private val questionsList = Constants.getQuestions()
    private var question: Questions = questionsList[currentPosition]
    private val options: List<TextView?> = listOf(op1, op2, op3, op4) as List<TextView?>
    private var selectedOption = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        setQuestion()
        val naamHai: String? = intent.getStringExtra(Constants.USERNAME)
        val x = findViewById<Button>(R.id.submit)
        x.setOnClickListener {
            if(currentPosition!=5){
                submit()
            }
            else{
                submitButDont()
                Toast.makeText(this, "temp = $temp", Toast.LENGTH_SHORT).show()
                val a = Intent(this, Result::class.java)
                a.putExtra(Constants.correctAnswers, temp.toString())
                a.putExtra(Constants.USERNAME, naamHai)
                startActivity(a)
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    fun opSelected(view: View) {
        if (truHaiKya) {
            when {
                view as TextView == op1 -> {
                    selectedOption = 0
                }
                view as TextView == op2 -> {
                    selectedOption = 1
                }
                view as TextView == op3 -> {
                    selectedOption = 2
                }
                view as TextView == op4 -> {
                    selectedOption = 3
                }
            }
            selectedButton?.setBackgroundResource(R.drawable.default_option_border_bg)
            selectedButton?.setTextColor(R.color.dfcolor)
            selectedButton = (view as TextView)
            selectedButton?.setBackgroundResource(R.drawable.default_option_border_clicked_bg)
            selectedButton?.setTextColor(R.color.black)
        } else {
            when {
                view as TextView == op1 -> {
                    selectedOption = 0
                }
                view as TextView == op2 -> {
                    selectedOption = 1
                }
                view as TextView == op3 -> {
                    selectedOption = 2
                }
                view as TextView == op4 -> {
                    selectedOption = 3
                }
            }
            selectedButton = (view as TextView)
            selectedButton?.setBackgroundResource(R.drawable.default_option_border_clicked_bg)
            selectedButton?.setTextColor(R.color.black)
            truHaiKya = true
        }
    }

    @SuppressLint("ResourceAsColor")
    fun submit(){
            if (selectedOption == question.cO) {
                temp++
                selectedButton?.setBackgroundResource(R.drawable.default_option_border_bg)
                selectedButton?.setTextColor(R.color.dfcolor)
                truHaiKya = false
                Toast.makeText(this, "$temp", Toast.LENGTH_SHORT).show()
                setQuestion()
            } else {
                selectedButton?.setBackgroundResource(R.drawable.default_option_border_bg)
                selectedButton?.setTextColor(R.color.dfcolor)
                truHaiKya = false
                Toast.makeText(this, "$temp", Toast.LENGTH_SHORT).show()
                setQuestion()
            }
    }
    @SuppressLint("ResourceAsColor")
    fun submitButDont(){
        if (selectedOption == question.cO) {
            temp++
            truHaiKya = false
        }
        else{
            truHaiKya = false
        }
    }
    private fun setQuestion(){
        currentPosition++
        progressBar = findViewById(R.id.tvBar)
        tvProg = findViewById(R.id.tvProg)
        tvQuestion = findViewById(R.id.tvQuestion)
        op1 = findViewById(R.id.op1)
        op2 = findViewById(R.id.op2)
        op3 = findViewById(R.id.op3)
        op4 = findViewById(R.id.op4)
        progressBar?.progress = currentPosition
        tvProg?.text = "$currentPosition/${progressBar?.max}"
        val questionsList = Constants.getQuestions()
        var question: Questions = questionsList[currentPosition-1]
        tvQuestion?.text = question.question
        op1?.text = question.o1
        op2?.text = question.o2
        op3?.text = question.o3
        op4?.text = question.o4
    }
}