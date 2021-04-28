package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_four.*

class QuestionFourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_four)
        val currentPosition = 4
        determinate_bar4.progress = currentPosition
        tvProgress4.text = "%"+"$currentPosition"+"0"
        tvQuestion4.setText(QuizActivity.quizQuestions.questions[3].question)
        val answerOne = QuizActivity.quizQuestions.questions[3].answer

        btnTrue4.setOnClickListener{
            if(answerOne == true){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionFiveActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }
        btnFalse4.setOnClickListener{
            if(answerOne == false){
                QuizActivity.score += 10
            }
            val quizQuestionNext = Intent(this, QuestionFiveActivity::class.java)
            startActivity(quizQuestionNext);
            finish()
        }

    }
}