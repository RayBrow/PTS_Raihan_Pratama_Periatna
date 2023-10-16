package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoginScreen : AppCompatActivity() {

    private val users = mapOf("siswa" to "123", "siswa2" to "1234")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val enteredEmail = etEmail.text.toString()
            val enteredPassword = etPassword.text.toString()

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                showToast("Isi Dengan Benar")
            } else if (isValidCredentials(enteredEmail, enteredPassword)) {
                showToast("Login Berhasil")
                startActivity(Intent(this, DashboardScreen::class.java))
            } else {
                showErrorMessage()
            }
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        return users[email] == password
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showErrorMessage() {
        AlertDialog.Builder(this)
            .setTitle("WARNING!!")
            .setMessage("Password Or Username Incorrect")
            .setPositiveButton(android.R.string.yes) { _, _ -> showToast(android.R.string.yes.toString()) }
            .show()
    }
}
