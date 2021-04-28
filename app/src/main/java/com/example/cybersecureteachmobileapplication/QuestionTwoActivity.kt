package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_two.*

class QuestionTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_two)
        val currentPosition = 2
        determinate_bar2.progress = currentPosition
        tvProgress2.text = "%"+"$currentPosition"+"0"
        tvQuestion2.setText(QuizActivity.quizQuestions.questions[1].question)
        val answerOne = QuizActivity.quizQuestions.questions[1].answer

        btnTrue2.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionThreeActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse2.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionThreeActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}