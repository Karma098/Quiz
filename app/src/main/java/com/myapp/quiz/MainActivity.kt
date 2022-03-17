@file:Suppress("DEPRECATION")

package com.myapp.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.Toast
import com.myapp.quiz.R.id.btn_start
import com.myapp.quiz.R.id.et_name
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1

class MainActivity : AppCompatActivity1() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

        val btn:Button=findViewById(R.id.btn_start)
        val etname:androidx.appcompat.widget.AppCompatEditText=findViewById(R.id.et_name)

        btn.setOnClickListener {

            if(etname.text.toString().isEmpty()){
                Toast.makeText(this,
                    "Please Enter Your Name broo!!", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etname.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}