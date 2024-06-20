package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.databinding.ActivityQuizactBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class quizact : AppCompatActivity() {
    private  lateinit var binding: ActivityQuizactBinding
    private lateinit var list:ArrayList<questionmodel>
    private var count:Int=0
    private var Score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizactBinding.inflate(layoutInflater)

        setContentView(binding.root)
        list= ArrayList<questionmodel>()
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener {
                doct->
                list.clear()
                for (i in doct.documents){
                   // list.clear()
                    var question=i.toObject(questionmodel::class.java)
                    list.add(question!!)
                }

                binding.qs.setText(list.get(0).qus.toString())
                binding.option1.setText(list.get(0).option1.toString())
                binding.option2.setText(list.get(0).option2.toString())
                binding.option3.setText(list.get(0).option3.toString())
                binding.option4.setText(list.get(0).option4.toString())
            }
     /*   list.add(questionmodel("who is the pm of india","modi","rahul","kejrival","amitshah","modi"))
        list.add(questionmodel("who is the pm of india","rahul","dhoni","amit","modi","modi"))
        list.add(questionmodel("who is the pm of india","modi","rahul","amitshah","rahul","modi"))
        list.add(questionmodel("who is the pm of india","rahul","modi","kejrival","amitshah","modi"))

        */

        binding.option1.setOnClickListener{
           nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }


    }

    private fun nextData(i: String) {

        if (count < list.size) {
            if (list.get(count).ans.equals(i)) {
                Score++
            }
        }
        count++
        if (count >= list.size) {
            var intent=Intent(this,result::class.java)
            intent.putExtra("score",Score)
            startActivity(intent)
            finish()
        } else {
            binding.qs.text = list.get(count).qus
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }
    }
}