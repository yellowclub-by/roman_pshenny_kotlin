package com.example.serphimchmops

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class game : AppCompatActivity() {
    var choice1 = ""
    var choice2 = ""
    var ready1 = false
    var ready2 = false
    var score1 = 0
    var score2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val playTop = findViewById<Button>(R.id.button1)
        val playBottom = findViewById<Button>(R.id.button2)

        val btn2Paper = findViewById<ImageView>(R.id.btn_2_paper)
        val btn2Rock = findViewById<ImageView>(R.id.btn_2_rock)
        val btn2Scissors = findViewById<ImageView>(R.id.btn_2_scissors)

        val btn1Paper = findViewById<ImageView>(R.id.btn_1_paper)
        val btn1Rock = findViewById<ImageView>(R.id.btn_1_rock)
        val btn1Scissors = findViewById<ImageView>(R.id.btn_1_scissors)

        val circleTop = findViewById<ImageView>(R.id.image1)
        val circleBottom = findViewById<ImageView>(R.id.image2)

        val score1Text = findViewById<TextView>(R.id.counter_person_1)
        val score2Text = findViewById<TextView>(R.id.counter_person_2)
        val fname = findViewById<TextView>(R.id.tv_top4)
        val sname = findViewById<TextView>(R.id.tv_top7)
        val winTop = findViewById<TextView>(R.id.win_top)
        val winBottom = findViewById<TextView>(R.id.win_bottom)

        val name1 = intent.getStringExtra("fname1") ?: "Игрок 1"
        val name2 = intent.getStringExtra("sname1") ?: "Игрок 2"

        fname.text = name1
        sname.text = name2
        btn1Paper.setOnClickListener {
            choice1 = "paper"
            circleBottom.setImageResource(R.drawable.paper)
        }
        btn1Rock.setOnClickListener {
            choice1 = "rock"
            circleBottom.setImageResource(R.drawable.rock)
        }
        btn1Scissors.setOnClickListener {
            choice1 = "scissors"
            circleBottom.setImageResource(R.drawable.scissories)
        }


        btn2Paper.setOnClickListener {
            choice2 = "paper"
            circleTop.setImageResource(R.drawable.paper)
        }
        btn2Rock.setOnClickListener {
            choice2 = "rock"
            circleTop.setImageResource(R.drawable.rock)
        }
        btn2Scissors.setOnClickListener {
            choice2 = "scissors"
            circleTop.setImageResource(R.drawable.scissories)
        }


        playBottom.setOnClickListener {
            if (choice1 != "") ready1 = true
            if (ready1 && ready2) game()
        }

        playTop.setOnClickListener {
            if (choice2 != "") ready2 = true
            if (ready1 && ready2) game()
        }
    }


    fun game() {
        val score1Text = findViewById<TextView>(R.id.counter_person_1)
        val score2Text = findViewById<TextView>(R.id.counter_person_2)
        val winTop = findViewById<TextView>(R.id.win_top)
        val winBottom = findViewById<TextView>(R.id.win_bottom)
        val circleTop = findViewById<ImageView>(R.id.image1)
        val circleBottom = findViewById<ImageView>(R.id.image2)

        if ((choice1 == "rock" && choice2 == "scissors") ||
            (choice1 == "scissors" && choice2 == "paper") ||
            (choice1 == "paper" && choice2 == "rock")) {
            score1++
            score1Text.text = "$score1"
            winTop.text = "ПРОИГРЫШ!"
            winBottom.text = "ПОБЕДА!"
        }
        else if ((choice2 == "rock" && choice1 == "scissors") ||
            (choice2 == "scissors" && choice1 == "paper") ||
            (choice2 == "paper" && choice1 == "rock")) {
            score2++
            score2Text.text = "$score2"
            winTop.text = "ПОБЕДА!"
            winBottom.text = "ПРОИГРЫШ!"
        }
        else if (choice1 == choice2) {
            winTop.text = "НИЧЬЯ!"
            winBottom.text = "НИЧЬЯ!"
        }

        Handler().postDelayed({
            choice1 = ""
            choice2 = ""
            ready1 = false
            ready2 = false
            circleTop.setImageDrawable(null)
            circleBottom.setImageDrawable(null)
            winTop.text = ""
            winBottom.text = ""
        }, 2000)
    }

}