package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_one.*
import kotlinx.android.synthetic.main.activity_question_two.*

class QuestionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_one)
        val currentPosition = 1
        determinate_bar1.progress = currentPosition
        tvProgress.text = "%"+"$currentPosition"+"0"
        tvQuestion.setText(QuizActivity.quizQuestions.questions[0].question)
        val answerOne = QuizActivity.quizQuestions.questions[0].answer

        btnTrue.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionTwoActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionTwoActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}


