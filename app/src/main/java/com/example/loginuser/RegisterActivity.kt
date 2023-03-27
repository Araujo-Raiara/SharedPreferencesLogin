package com.example.loginuser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginuser.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonCancel = binding.buttonCancel
        buttonCancel.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        val buttonOk = binding.buttonOk
        buttonOk.setOnClickListener {
            prefs.username = binding.etUsername.text.toString()
            prefs.password = binding.etPassword.text.toString()
            prefs.name = binding.etNome.text.toString()
            prefs.cpf = binding.etCPF.text.toString()

            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

    }


}