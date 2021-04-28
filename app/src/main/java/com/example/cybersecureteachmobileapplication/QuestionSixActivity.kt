package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_six.*

class QuestionSixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_six)
        val currentPosition = 6
        determinate_bar6.progress = currentPosition
        tvProgress6.text = "%"+"$currentPosition"+"0"
        tvQuestion6.setText(QuizActivity.quizQuestions.questions[5].question)
        val answerOne = QuizActivity.quizQuestions.questions[5].answer

        btnTrue6.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionSevenActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse6.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionSevenActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}