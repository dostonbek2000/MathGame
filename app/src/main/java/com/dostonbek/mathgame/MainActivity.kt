package com.dostonbek.mathgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var number1: TextView
    private lateinit var number2: TextView
    private lateinit var operator: TextView
    private lateinit var equal: TextView
    private lateinit var userResult: EditText
    private lateinit var chack: Button
    private lateinit var random: Random
    var sum: Int = 0
    var sum2:Int = 0
    private var result: Int? = null
    private var count: TextView? = null
    private  var wrong:TextView? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        random = Random()
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.nummer2)
        operator = findViewById(R.id.operator)
        equal = findViewById(R.id.equal)
        userResult = findViewById(R.id.userResult)
        chack = findViewById(R.id.check)
        count = findViewById(R.id.count)
        wrong = findViewById(R.id.wrong)
        math()
        chack.setOnClickListener {
            if (result == userResult.text.toString().toInt()) {
                Toast.makeText(this, "True", Toast.LENGTH_SHORT).show()
                sum += 1
                count?.text = "True: ${sum.toString()}"
            } else {
                Toast.makeText(this, "False", Toast.LENGTH_SHORT).show()
                sum2 += 1
                wrong?.text ="False: ${sum2.toString()}"
            }
            math()
            userResult.setText("")

        }
    }

    fun math() {
        number1.text = random.nextInt(100).toString()
        number2.text = random.nextInt(100).toString()
        val operatorRandom = random.nextInt(4)



        when (operatorRandom) {

            0 -> {
                operator.text = "+"
                result = number1.text.toString().toInt() + number2.text.toString().toInt()
            }
            1 -> {
                operator.text = "-"
                result = number1.text.toString().toInt() - number2.text.toString().toInt()
            }
            2 -> {
                operator.text = "*"
                result = number1.text.toString().toInt() * number2.text.toString().toInt()
            }
            3 -> {
                operator.text = "/"
                result = number1.text.toString().toInt() / number2.text.toString().toInt()
            }

        }


    }


}