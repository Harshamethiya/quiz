package com.example.quiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.text.toString(),
                binding.pass.text.toString() ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "user created", Toast.LENGTH_LONG).show()
                    }
                   else{
                        Toast.makeText(this,"user not created",Toast.LENGTH_LONG).show()
                    }
            }


        }

    }


}