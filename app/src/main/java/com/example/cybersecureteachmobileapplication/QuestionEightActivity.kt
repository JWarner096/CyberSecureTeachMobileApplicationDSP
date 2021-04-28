package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_eight.*

class QuestionEightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_eight)
        val currentPosition = 8
        determinate_bar8.progress = currentPosition
        tvProgress8.text = "%"+"$currentPosition"+"0"
        tvQuestion8.setText(QuizActivity.quizQuestions.questions[7].question)
        val answerOne = QuizActivity.quizQuestions.questions[7].answer

        btnTrue8.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionNineActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse8.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionNineActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}