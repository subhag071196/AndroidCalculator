package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    public fun evaluate(view: android.view.View) {
        var txtView : TextView = findViewById(R.id.display_text)
        var xpression : String = txtView.text.toString()
        xpression = xpression.reversed()
        var i : Int = 0
        var valid : Boolean = true
        var nums : Stack<Int> = Stack<Int>()
        var syms : Stack<Char> = Stack<Char>()
        var numCurr : Int = 0
        for (c : Char in xpression) {
            if (c <= '9' && c >= '0') {
                numCurr *= 10
                numCurr += c.toInt()
            } else {
                Log.i("DEBUG_EXPRESSION_NUMBERS",numCurr.toString())
                nums.push(numCurr)
                numCurr = 0
                Log.i("DEBUG_EXPRESSION_SYMBOLS",c.toString())
                syms.push(c)
            }
        }

        for (elem : Int in nums.elements().toList()) {
            Log.i("STACK_NUMBERS_CONTENTS", elem.toString()+"\n")
        }


/*
        while (!syms.empty()) {
            var currSym : Char = syms.peek()
            syms.pop()
            var currResult : Int = 0
            var num1 : Int
            var num2 : Int
            if (!nums.empty()) {
                num1 = nums.peek()
                nums.pop()
            } else {
                var t = Toast.makeText(this, "Invalid expression !", Toast.LENGTH_SHORT)
                t.show()
                valid = false
                break
            }
            if(!nums.empty()) {
                num2 = nums.peek()
                nums.pop()
            } else {
                var t = Toast.makeText(this, "Invalid expression !", Toast.LENGTH_SHORT)
                t.show()
                valid = false
                break
            }
            currResult = evalMiniXpression(num1,num2,currSym)
            nums.push(currResult)
        }*/
        if (valid) txtView.text = nums.peek().toString()
    }

    private fun evalMiniXpression(num1: Int, num2: Int, currSym: Char): Int {
        val result : Int = when (currSym) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> 0
        }
        return result
    }

    public fun clearDisplay(view: android.view.View) {
        var tv: TextView = view.findViewById(R.id.display_text)
        var msg: String = tv.text.toString()
        if (msg == "Start Calculating..") {
            tv.text = ""
        }
    }

    public fun backSpace(view: android.view.View) {
        var textView: TextView = findViewById(R.id.display_text)
        var text: String = textView.text.toString()
        var newText = text.dropLast(1)
        textView.text = newText
    }

    public fun clear(view: android.view.View) {
        var textView: TextView = findViewById(R.id.display_text)
        textView.text = ""
    }

    public fun exit(view: android.view.View) {

    }

    public fun appendChar(view: android.view.View) {
        var vId = view.id
        var toAppend: Char = when (vId) {
            R.id.zero -> '0'
            R.id.one -> '1'
            R.id.two -> '2'
            R.id.three -> '3'
            R.id.four -> '4'
            R.id.five -> '5'
            R.id.six -> '6'
            R.id.seven -> '7'
            R.id.eight -> '8'
            R.id.nine -> '9'
            R.id.plus -> '+'
            R.id.minus -> '-'
            R.id.divide -> '/'
            R.id.multiply -> '*'
            else -> '$'
        }
        var tv: TextView = findViewById(R.id.display_text)
        var msg: String = tv.text.toString()
        msg = msg + toAppend
        tv.text = msg
    }


}
