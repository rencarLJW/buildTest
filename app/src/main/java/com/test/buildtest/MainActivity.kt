package com.test.buildtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "VERSION_NAME : ${BuildConfig.VERSION_NAME}" +
                "VERSION_CODE : ${BuildConfig.VERSION_CODE}" +
                "is DEBUG : ${BuildConfig.DEBUG}"
    }
}