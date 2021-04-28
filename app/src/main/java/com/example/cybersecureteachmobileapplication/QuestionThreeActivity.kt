package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_three.*


class QuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_three)
        val currentPosition = 3
        determinate_bar3.progress = currentPosition
        tvProgress3.text = "%"+"$currentPosition"+"0"
        tvQuestion3.setText(QuizActivity.quizQuestions.questions[2].question)
        val answerOne = QuizActivity.quizQuestions.questions[2].answer

        btnTrue3.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionFourActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse3.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionFourActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}