package com.example.loginuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginuser.databinding.ActivityNoteBinding

const val FILENAME = "mynote.txt"

class NoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonCancel = binding.buttonCancel
        buttonCancel.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        val buttonOk = binding.buttonOk
        buttonOk.setOnClickListener {
// TODO: Salvar em um arquivo

            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

    }
}