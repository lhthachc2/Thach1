package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private lateinit var wordViewModel: WordViewModel
    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = Adapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this, Observer<List<Model>> {
            adapter.setWords(it)
        })
        Button = findViewById(R.id.button)
        Button.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK)
        {
            var Username: String = intentData!!.getStringExtra(NewWordActivity.EXTRA_REPLY)
            var Password: String = intentData.getStringExtra(NewWordActivity.EXTRA_REPLY_P)
            var Email: String = intentData.getStringExtra(NewWordActivity.EXTRA_REPLY_E)
            var Address: String = intentData.getStringExtra(NewWordActivity.EXTRA_REPLY_A)
            var Gender: String = intentData.getStringExtra(NewWordActivity.EXTRA_REPLY_G)
            val model : Model = Model(Username,Password,Email,Address,Gender)
            wordViewModel.insert(model)
            Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(
                applicationContext,
               "Not Save",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}
