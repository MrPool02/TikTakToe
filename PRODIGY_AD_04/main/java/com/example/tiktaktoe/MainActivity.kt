@file:Suppress("UNUSED_EXPRESSION")

package com.example.tiktaktoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var flag = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun check(view: View) {
        val btnCurrent = view as Button
        count++
        if (btnCurrent.text == "") {
            btnCurrent.text = if (flag == 0) "X" else "O"
            flag = 1 - flag

            val b1 = findViewById<Button>(R.id.btn1).text.toString()
            val b2 = findViewById<Button>(R.id.btn2).text.toString()
            val b3 = findViewById<Button>(R.id.btn3).text.toString()
            val b4 = findViewById<Button>(R.id.btn4).text.toString()
            val b5 = findViewById<Button>(R.id.btn5).text.toString()
            val b6 = findViewById<Button>(R.id.btn6).text.toString()
            val b7 = findViewById<Button>(R.id.btn7).text.toString()
            val b8 = findViewById<Button>(R.id.btn8).text.toString()
            val b9 = findViewById<Button>(R.id.btn9).text.toString()

            when {
                b1 == b2 && b2 == b3 && b3 != "" -> showToastAndNewGame(b1)
                b4 == b5 && b5 == b6 && b6 != "" -> showToastAndNewGame(b4)
                b7 == b8 && b8 == b9 && b9 != "" -> showToastAndNewGame(b7)
                b1 == b4 && b4 == b7 && b7 != "" -> showToastAndNewGame(b1)
                b2 == b5 && b5 == b8 && b8 != "" -> showToastAndNewGame(b2)
                b3 == b6 && b6 == b9 && b9 != "" -> showToastAndNewGame(b3)
                b1 == b5 && b5 == b9 && b9 != "" -> showToastAndNewGame(b1)
                b3 == b5 && b5 == b7 && b7 != "" -> showToastAndNewGame(b3)
                count == 9 -> {
                    Toast.makeText(this, "Match is Draw", Toast.LENGTH_LONG).show()
                    newGame()
                }
            }
        }
    }

    private fun showToastAndNewGame(winner: String) {
        Toast.makeText(this, "Winner is $winner", Toast.LENGTH_LONG).show()
        newGame()
    }

    private fun newGame() {
        findViewById<Button>(R.id.btn1).text = ""
        findViewById<Button>(R.id.btn2).text = ""
        findViewById<Button>(R.id.btn3).text = ""
        findViewById<Button>(R.id.btn4).text = ""
        findViewById<Button>(R.id.btn5).text = ""
        findViewById<Button>(R.id.btn6).text = ""
        findViewById<Button>(R.id.btn7).text = ""
        findViewById<Button>(R.id.btn8).text = ""
        findViewById<Button>(R.id.btn9).text = ""
        flag = 0
        count = 0
    }
}
