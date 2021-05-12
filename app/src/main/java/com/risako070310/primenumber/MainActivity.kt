package com.risako070310.primenumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        private const val QUESTION_COUNT = 10
    }

    val question = IntArray(QUESTION_COUNT)
    var point = 0
    var answerCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until QUESTION_COUNT) {
            val number = Random.nextInt(1000)
            question[i] = number
        }

        point = 0
        answerCount = 0

        textView.text = question[answerCount].toString() + ""
        textView.setTextColor(Color.BLACK)

        maruButton.setOnClickListener {
            var answer = true
            val number = question[answerCount]

            for(i in 2 until number){
                if(number % i == 0){
                    answer = false
                    break
                }
            }
            if(answer) {
                point++
                Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show()
            }
            answerCount++

            if(answerCount == QUESTION_COUNT) {
                textView.text = point.toString() + "点"
                textView.setTextColor(Color.RED)

                point = 0
                answerCount = 0
            } else {
                textView.text = question[answerCount].toString() + ""
                textView.setTextColor(Color.BLACK)
            }
        }

        batsuButton.setOnClickListener {
            var answer = true
            val number = question[answerCount]

            for(i in 2 until number){
                if(number % i == 0){
                    answer = false
                    break
                }
            }
            if(answer) {
                Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show()
            } else {
                point++
                Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show()
            }
            answerCount++

            if(answerCount == QUESTION_COUNT) {
                textView.text = point.toString() + "点"
                textView.setTextColor(Color.RED)

                point = 0
                answerCount = 0
            } else {
                textView.text = question[answerCount].toString() + ""
                textView.setTextColor(Color.BLACK)
            }
        }
    }
}