package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var Username: EditText
    private lateinit var Password: EditText
    private lateinit var signUpButton: Button
    private lateinit var loginButton: Button
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Username = findViewById(R.id.editText)
        Password = findViewById(R.id.editText2)
        signUpButton = findViewById(R.id.button3)
        loginButton = findViewById(R.id.button2)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        loginButton.setOnClickListener {
            val isValid = wordViewModel!!.checkValidLogin(editText!!.text.toString(), editText2!!.text.toString())
            if (isValid) {
                Toast.makeText(this, "Successfully Logged In!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivityForResult(intent, 1)
            } else {
                Toast.makeText(this, "Invalid Login!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
