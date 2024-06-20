package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
       Handler(Looper.getMainLooper()).postDelayed(3000){
          if (Firebase.auth.currentUser!=null)
           {
               val i= Intent(this,quizact::class.java)
               startActivity(i)
           }
           else{
               val i= Intent(this,MainActivity::class.java)
               i.putExtra("mode","signup")
               startActivity(i)
           }
           val i= Intent(this,quizact::class.java)
           startActivity(i)
       }
    }
}