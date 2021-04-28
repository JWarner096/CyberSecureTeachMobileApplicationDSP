package com.example.cybersecureteachmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_welcome.*

class EmailActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationView.setNavigationItemSelectedListener {
            val welcomePage = Intent(this, WelcomeActivity::class.java)
            val introductionPage = Intent(this, IntroductionActivity::class.java)
            val passwordPage = Intent(this, PasswordActivity::class.java)
            val emailPage = Intent(this, EmailActivity::class.java)
            val ipPage = Intent(this, InternetActivity::class.java)
            val quizPage = Intent(this, QuizActivity::class.java)
            when(it.itemId){
                R.id.menuWelcome -> startActivity(welcomePage);
                R.id.menuIntroduction -> startActivity(introductionPage);
                R.id.menuPassword -> startActivity(passwordPage);
                R.id.menuEmail -> startActivity(emailPage);
                R.id.menuIP -> startActivity(ipPage);
                R.id.menuQuiz -> startActivity(quizPage);
            }
            finish()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}