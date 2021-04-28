package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_quiz.*
import okhttp3.*
import java.io.IOException

data class QuizQuestions(val questions: List<Question> )
data class Question(val question: String, val answer: Boolean)

//Okhttp3 - code adapted from: https://square.github.io/okhttp/
//Gson - code adapted from: https://github.com/google/gson/blob/master/UserGuide.md

class QuizActivity : AppCompatActivity() {
    companion object {
        var score = 0
        lateinit var quizQuestions: QuizQuestions
    }
    //used for race conditions stop from loading to fast
    var questionsLoaded: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val url = "http://192.168.1.26:8080/CyberTeachWebApplication/QuestionsServlet"
        val request = Request.Builder().url(url).build()
        //uses OkHttpClient used to call the url within a background thread
        val client = OkHttpClient()
        //enqueue runs on background thread making the NetworkOnMainThreadException not occur
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val info = response?.body?.string()
                val gson = GsonBuilder().create()
                quizQuestions = gson.fromJson(info, QuizQuestions::class.java)
                questionsLoaded = true
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
            }
        })
        btnQuizStart.setOnClickListener{
            if(questionsLoaded) {
                score = 0
                val quizQuestion = Intent(this, QuestionOneActivity::class.java)
                startActivity(quizQuestion);
            }
            else{
                Toast.makeText(this, "Questions not ready",Toast.LENGTH_SHORT).show()
            }
        }
        }
}

