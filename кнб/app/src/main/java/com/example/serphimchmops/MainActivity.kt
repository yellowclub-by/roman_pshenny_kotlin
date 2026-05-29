package com.example.serphimchmops

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Firstuser: EditText = findViewById(R.id.one)
        val Secuser: EditText = findViewById(R.id.two)
        val boton:Button = findViewById(R.id.baton)
    

        boton.setOnClickListener {
            val fname = Firstuser.text.toString()
            val sname = Secuser.text.toString()

            val intent = Intent(this, game::class.java)
            intent.putExtra("fname1", fname)
            intent.putExtra("sname1", sname)

            startActivity(intent)
        }
    }
}
