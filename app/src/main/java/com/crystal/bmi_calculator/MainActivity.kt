package com.crystal.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText:EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weigtEditText)
        val resultButton = findViewById<Button>(R.id.resultButton)

        //interface 를 람다형식으로 구현해서 사용할 수 있음
        resultButton.setOnClickListener {
//            Log.d("MainActivity","result button이 클릭되었습니다." )

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                //경고 알럿다이얼로그, 토스트
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //이 아래는 빈값이 올 수 없음.
            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()
//            Log.d("MainActivity", "height : + $height, weight : weight")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}