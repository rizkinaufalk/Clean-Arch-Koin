package com.rizki.cleanarch.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.rizki.cleanarch.R

class OpeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        nextLayout()
    }

    fun nextLayout(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java).apply {

            })
        }, 1000)
    }
}