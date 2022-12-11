package com.example.firebasehw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorTreeAdapter.ViewBinder
import android.widget.Toast
import com.example.firebasehw4.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener {
            var email = binding.editTextEmailAddress.text.toString()
            var password = binding.editTextPassword.text.toString()

            if (email.isEmpty() or password.isEmpty()){
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_SHORT).show()

            }
            else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this@MainActivity,"Success",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }



    }
}