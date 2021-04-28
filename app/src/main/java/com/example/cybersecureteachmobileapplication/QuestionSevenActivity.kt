package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_seven.*

class QuestionSevenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_seven)
        val currentPosition = 7
        determinate_bar7.progress = currentPosition
        tvProgress7.text = "%"+"$currentPosition"+"0"
        tvQuestion7.setText(QuizActivity.quizQuestions.questions[6].question)
        val answerOne = QuizActivity.quizQuestions.questions[6].answer

        btnTrue7.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionEightActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse7.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionEightActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}