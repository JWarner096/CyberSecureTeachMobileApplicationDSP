package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_five.*

class QuestionFiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_five)
        val currentPosition = 5
        determinate_bar5.progress = currentPosition
        tvProgress5.text = "%"+"$currentPosition"+"0"
        tvQuestion5.setText(QuizActivity.quizQuestions.questions[4].question)
        val answerOne = QuizActivity.quizQuestions.questions[4].answer

        btnTrue5.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionSixActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse5.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionSixActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}