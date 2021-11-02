package com.crystal.bmi_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

//        Log.d("ResultActivity", "height : $height, weight : $weight")
        val bmi = weight / (height / 100.0).pow(2.0) //double
        //Math.pow(height/100.0 , 2.0) java 스타일, 위에는 더블형 자체에 pow 함수가 존재해서 함수형으로 변경해서 사용

        val resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.0 -> "정상 체중"
            else -> "저체중"
        }
        val resultValueTextView = findViewById<TextView>(R.id.resultBMITextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultBMIStringTextVIew)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}