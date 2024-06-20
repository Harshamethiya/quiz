package com.example.quiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.databinding.ActivityResultBinding
import com.google.android.material.color.utilities.Score

class result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sc.setText("Congrats !!! Your Score is : ${intent.getIntExtra("score",0)}")

    }
}