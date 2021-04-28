package com.example.cybersecureteachmobileapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

//Anko - code adapted from: https://en.proft.me/2018/04/19/how-fetch-data-over-network-kotlin-and-android/

class LoginActivity : AppCompatActivity() {
    companion object{
        var username = ""
        var password = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            username = editUsername.text.toString()
            password = editPassword.text.toString()
            val welcomePage = Intent(this, WelcomeActivity::class.java)
                doAsync{
                    try {
                    var loginResponse = URL("http://192.168.1.26:8080/CyberTeachWebApplication/MobileLoginServlet?username=$username&password=$password").readText()

                    if (loginResponse.equals("1\r\n") ){
                        startActivity(welcomePage);
                    }
                    else
                    {
                        uiThread {
                            Toast.makeText(this@LoginActivity,"Invalid Login",Toast.LENGTH_SHORT).show();
                        }
                    }
                    } finally{

                    }
                }
            }

        }
}
