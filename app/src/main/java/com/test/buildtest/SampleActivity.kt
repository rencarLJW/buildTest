package com.test.buildtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.buildtest.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {
    lateinit var binding: ActivitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("screenText")) {
            binding.intentTv.text = intent.getStringExtra("screenText")
        }

        binding.inputBtn.setOnClickListener { binding.resultTv.text = binding.inputEt.text }
    }
}

