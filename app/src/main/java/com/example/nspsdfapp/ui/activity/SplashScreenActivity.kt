package com.example.nspsdfapp.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.nspsdfapp.R
import com.example.nspsdfapp.utils.makeStatusBarTransparent

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        makeStatusBarTransparent()
        initVariables()
        checkUser()
    }

    private fun initVariables() {
        sharedPreferences = this.getSharedPreferences("com.example.nspsdfapp", MODE_PRIVATE)
    }

    private fun checkUser() {
        object : CountDownTimer(1500, 700) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() = with(sharedPreferences) {
                if (getBoolean("userLogged", false)) {
                    startActivity(
                        Intent(
                            this@SplashScreenActivity,
                            MainActivity::class.java
                        )
                    )
                } else {
                    startActivity(
                        Intent(
                            this@SplashScreenActivity,
                            LoginActivity::class.java
                        )
                    )
                }
                finish()
            }

        }.start()
    }
}