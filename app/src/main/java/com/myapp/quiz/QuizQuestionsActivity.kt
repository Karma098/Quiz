package com.myapp.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

@Suppress("DEPRECATION")
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null



//    private var progressBar:ProgressBar=findViewById(R.id.progressBar)
//    private var tvprogress:TextView=findViewById(R.id.tv_progress)
//    private var tvquestion:TextView=findViewById(R.id.tv_question)
//    private var ivimage:ImageView=findViewById(R.id.iv_image)
//    private var tvoptionone:TextView=findViewById(R.id.tv_option_one)
//    private var tvoptiontwo:TextView=findViewById(R.id.tv_option_two)
//    private var tvoptionthree:TextView=findViewById(R.id.tv_option_three)
//    private var tvoptionfour:TextView=findViewById(R.id.tv_option_four)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val tvoptionone:TextView=findViewById(R.id.tv_option_one)
        val tvoptiontwo:TextView=findViewById(R.id.tv_option_two)
        val tvoptionthree:TextView=findViewById(R.id.tv_option_three)
        val tvoptionfour:TextView=findViewById(R.id.tv_option_four)
        val btn:Button=findViewById(R.id.btn_submit)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tvoptionone.setOnClickListener(this)
        tvoptiontwo.setOnClickListener(this)
        tvoptionthree.setOnClickListener(this)
        tvoptionfour.setOnClickListener(this)
        btn.setOnClickListener(this)
    }

    private fun setQuestion(){
        val tvprogress:TextView=findViewById(R.id.tv_progress)
        val progressBar:ProgressBar=findViewById(R.id.progressBar)
        val tvquestion:TextView=findViewById(R.id.tv_question)
        val ivimage:ImageView=findViewById(R.id.iv_image)
        val tvoptionone:TextView=findViewById(R.id.tv_option_one)
        val tvoptiontwo:TextView=findViewById(R.id.tv_option_two)
        val tvoptionthree:TextView=findViewById(R.id.tv_option_three)
        val tvoptionfour:TextView=findViewById(R.id.tv_option_four)
        val btn:Button=findViewById(R.id.btn_submit)

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btn.text = "FINISH"
        }else{
            btn.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tvprogress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvquestion.text = question!!.question
        ivimage.setImageResource(question.image)
        tvoptionone.text = question.optionOne
        tvoptiontwo.text = question.optionTwo
        tvoptionthree.text = question.optionThree
        tvoptionfour.text = question.optionFour

    }

    private fun defaultOptionsView(){

        val tvoptionone:TextView=findViewById(R.id.tv_option_one)
        val tvoptiontwo:TextView=findViewById(R.id.tv_option_two)
        val tvoptionthree:TextView=findViewById(R.id.tv_option_three)
        val tvoptionfour:TextView=findViewById(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0,tvoptionone)
        options.add(0,tvoptiontwo)
        options.add(0,tvoptionthree)
        options.add(0,tvoptionfour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {

        val tvoptionone:TextView=findViewById(R.id.tv_option_one)
        val tvoptiontwo:TextView=findViewById(R.id.tv_option_two)
        val tvoptionthree:TextView=findViewById(R.id.tv_option_three)
        val tvoptionfour:TextView=findViewById(R.id.tv_option_four)
        val btn:Button=findViewById(R.id.btn_submit)

        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tvoptionone, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tvoptiontwo,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tvoptionthree,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tvoptionfour,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        btn.text = "FINISH"
                    }else{
                        btn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {

        val tvoptionone: TextView = findViewById(R.id.tv_option_one)
        val tvoptiontwo: TextView = findViewById(R.id.tv_option_two)
        val tvoptionthree: TextView = findViewById(R.id.tv_option_three)
        val tvoptionfour: TextView = findViewById(R.id.tv_option_four)

        when (answer) {
            1 -> {
                tvoptionone.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvoptiontwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvoptionthree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvoptionfour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }


}