package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_question_results.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

//Anko - code adapted from: https://en.proft.me/2018/04/19/how-fetch-data-over-network-kotlin-and-android/
class QuestionResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_results)
        tvResults.setText("%"+QuizActivity.score.toString())
        val welcomePage = Intent(this, WelcomeActivity::class.java)
        val returnToQuizStart = Intent(this, QuizActivity::class.java)
        btnSubmit.setOnClickListener{
            doAsync{

                    var loginResponse = URL("http://192.168.1.26:8080/CyberTeachWebApplication/ScoreUpdateServlet?username=${LoginActivity.username}&password=${LoginActivity.password}&score=${QuizActivity.score}").readText()
                    if (loginResponse.equals("") ){
                        startActivity(welcomePage);
                        finish()
                    }
                 }
            }
        btnTryAgain.setOnClickListener{
            startActivity(returnToQuizStart);
            finish()
        }
        }
}


