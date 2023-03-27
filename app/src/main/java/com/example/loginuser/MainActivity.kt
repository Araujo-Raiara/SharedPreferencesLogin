package com.example.loginuser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginuser.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            if (binding.userLogin.text.toString() == prefs.username && binding.passwordUser.text.toString() == prefs.password) {
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, NoteActivity::class.java))

                val inputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.loginBtn.windowToken, 0)}

            else {
                Snackbar.make(binding.root, R.string.invalid_credentials,  Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.newUserBtn.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }

    }


}