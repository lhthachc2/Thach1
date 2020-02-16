package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {

    private lateinit var Username: EditText
    private lateinit var Password: EditText
    private lateinit var Email: EditText
    private lateinit var Address: EditText
    private lateinit var Gender: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        Username = findViewById(R.id.edusername)
        Password = findViewById(R.id.edpassword)
        Email = findViewById(R.id.edemail)
        Address = findViewById(R.id.edaddress)
        Gender = findViewById(R.id.edgioitinh)

        val button = findViewById<Button>(R.id.save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(Username.text)||TextUtils.isEmpty(Password.text)||TextUtils.isEmpty(Email.text)||TextUtils.isEmpty(Address.text)||TextUtils.isEmpty(Gender.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else
            {
                val username = Username.text.toString()
                val password = Password.text.toString()
                val email = Email.text.toString()
                val address = Address.text.toString()
                val gender = Gender.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, username)
                replyIntent.putExtra(EXTRA_REPLY_P, password)
                replyIntent.putExtra(EXTRA_REPLY_E, email)
                replyIntent.putExtra(EXTRA_REPLY_A, address)
                replyIntent.putExtra(EXTRA_REPLY_G, gender)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "Username"
        const val EXTRA_REPLY_P = "Password"
        const val EXTRA_REPLY_E = "Email"
        const val EXTRA_REPLY_A = "Address"
        const val EXTRA_REPLY_G = "Gender"
    }
}
