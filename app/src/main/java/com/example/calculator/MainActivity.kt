package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R.layout.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun Calculate(view : android.view.View) {

    }

    public fun QuitApp(view : android.view.View) {

    }

    public fun Clear(view : android.view.View) {
        var tv : TextView = findViewById(R.id.display)
        tv.text = ""
    }

    public fun appendPlus(view : android.view.View) {

    }

    public fun appendMinus(view : android.view.View) {

    }

    public fun appendDivide(view : android.view.View) {

    }

    public fun appendMultiply(view : android.view.View) {

    }
}