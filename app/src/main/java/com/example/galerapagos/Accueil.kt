package com.example.galerapagos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView

class Accueil : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)

        val introductionText: TextView = findViewById(R.id.introduction)
        introductionText.movementMethod = ScrollingMovementMethod()


        val jouer = findViewById<View>(R.id.jouer)

        jouer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

}