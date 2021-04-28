package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_nine.*

class QuestionNineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_nine)
        val currentPosition = 9
        determinate_bar9.progress = currentPosition
        tvProgress9.text = "%"+"$currentPosition"+"0"
        tvQuestion9.setText(QuizActivity.quizQuestions.questions[8].question)
        val answerOne = QuizActivity.quizQuestions.questions[8].answer

        btnTrue9.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionTenActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse9.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionTenActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}