package com.example.nac1.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.nac1.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        supportActionBar?.hide()

        Handler().postDelayed({
            val i = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(i)
            finish()
        },  3000)
    }
}