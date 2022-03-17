package com.myapp.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val tvname:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.tv_score)
        val btn:Button=findViewById(R.id.btn_finish)
        val btnshare:Button=findViewById(R.id.bt_share)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tvname.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvscore.text = "Your score is $correctAnswer/$totalQuestions"

        btn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        btnshare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val share = ":( 🥲🥲🥲 Manually kardo, Link nhi h iska 🥺🥺 "
            val sub = "Share The App"
            intent.putExtra(Intent.EXTRA_TEXT, share)
            intent.putExtra(Intent.EXTRA_SUBJECT, sub)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }
    }
}