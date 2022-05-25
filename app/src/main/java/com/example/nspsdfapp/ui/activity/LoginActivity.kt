package com.example.nspsdfapp.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nspsdfapp.databinding.ActivityLoginBinding
import com.example.nspsdfapp.utils.Data.checkUserLogin
import com.example.nspsdfapp.utils.makeStatusBarTransparent

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVariables()
        makeStatusBarTransparent()
        setClickListeners()
    }

    private fun initVariables() {
        sharedPreferences = this.getSharedPreferences("com.example.nspsdfapp", MODE_PRIVATE)
    }

    private fun setClickListeners() = with(binding) {
        btnLogin.setOnClickListener {
            if (teName.text!!.isNotEmpty() && tePassword.text!!.isNotEmpty()) {
                if (checkUserLogin(teName.text.toString(), tePassword.text.toString())) {
                    sharedPreferences.edit().putBoolean("userLogged", true).apply()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Can'not log in", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@LoginActivity, "Credentials missing", Toast.LENGTH_SHORT).show()
            }
        }

    }

}