package com.example.loginuser

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginuser.databinding.ActivityNoteBinding
import java.io.FileOutputStream

const val FILENAME = "mynote.txt"

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonCancel = binding.buttonCancel
        buttonCancel.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        binding.saveNoteBtn.setOnClickListener {
            val nota = binding.noteEt.text.toString()

            val noteDetails = "nota_${System.currentTimeMillis()}.txt"

            val outputStream: FileOutputStream = openFileOutput(noteDetails, Context.MODE_PRIVATE)
            outputStream.write(nota.toByteArray())
            outputStream.close()
            Toast.makeText(this, "A nota foi salva", Toast.LENGTH_LONG).show()
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        val prefs = Prefs(this)
        if (prefs.username != null && prefs.cpf != null) {
            val welcomeMessage = getString(R.string.welcome_tv, prefs.username, prefs.cpf)
            binding.textPersonalGreeting.text = welcomeMessage
        }

    }


}
