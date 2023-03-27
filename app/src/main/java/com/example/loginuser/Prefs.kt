package com.example.loginuser

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class Prefs(private val context: Context) {

    private val EMAIL = "email"
    private val PASS = "pass"
    private val NAME = "name"
    private val USERNAME = "username"

    private val APP_PREFS = "my-prefs-file"
    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE)

    private val mainKeyAlias by lazy {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        MasterKeys.getOrCreate(keyGenParameterSpec)
    }

    private val encryptedSharedPrefs by lazy {
        val sharedPrefsFile = "EncryptPref"

        EncryptedSharedPreferences.create(
            sharedPrefsFile,
            mainKeyAlias,
            context.applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var username: String?
        get() = sharedPrefs.getString(USERNAME, "")
        set(value) {
            if (isValidUsername(value)) {
                sharedPrefs.edit().putString(USERNAME, value).apply()
            } else {
                throw IllegalArgumentException("Invalid username")
            }
        }
    var cpf: String?
        get() = sharedPrefs.getString(EMAIL, "")
        set(value) = sharedPrefs.edit().putString(EMAIL, value).apply()

    var password: String?
        get() = encryptedSharedPrefs.getString(PASS, "")
        set(value) {
            if (isValidPassword(value)) {
                encryptedSharedPrefs.edit().putString(PASS, value).apply()
            } else {
                throw IllegalArgumentException("Invalid password")
            }
        }

    var name: String?
        get() = sharedPrefs.getString(NAME, "")
        set(value) = sharedPrefs.edit().putString(NAME, value).apply()

    private fun isValidUsername(username: String?): Boolean {
        return !username.isNullOrBlank() && username.length >= 6 && !username.contains("[!@#$%^&*(),.?\":{}|<>]".toRegex())
    }

    private fun isValidPassword(password: String?): Boolean {
        return !password.isNullOrBlank() && password.length >= 6 && !password.contains("[!@#$%^&*(),.?\":{}|<>]".toRegex())
    }
}