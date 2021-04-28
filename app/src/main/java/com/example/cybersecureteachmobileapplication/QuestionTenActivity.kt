package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_ten.*

class QuestionTenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_ten)
        val currentPosition = 10
        determinate_bar10.progress = currentPosition
        tvProgress10.text = "%"+"$currentPosition"+"0"
        tvQuestion10.setText(QuizActivity.quizQuestions.questions[9].question)
        val answerOne = QuizActivity.quizQuestions.questions[9].answer

        btnTrue10.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizResultsNext = Intent(this, QuestionResultsActivity::class.java)
            startActivity(quizResultsNext);
            finish()
        }
        btnFalse10.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizResultsNext = Intent(this, QuestionResultsActivity::class.java)
            startActivity(quizResultsNext);
            finish()
        }

    }
}