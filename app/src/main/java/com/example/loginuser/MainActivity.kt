package com.example.loginuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val password = findViewById<EditText>(R.id.password_user)

        val buttonLogin = findViewById<Button>(R.id.login_btn)
        buttonLogin.setOnClickListener {
            if (userLogin.text.toString() == prefs.username &&
                password.text.toString() == prefs.password
            ) {
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext, NoteActivity::class.java))
            } else {
                //
                // TODO: colocar um snack e apagar os textos dos campos
            }
        }

        val buttonNewUser = findViewById<Button>(R.id.new_user_btn)
        buttonNewUser.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
    }
}