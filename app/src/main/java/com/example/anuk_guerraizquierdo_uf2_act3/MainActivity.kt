package com.example.anuk_guerraizquierdo_uf2_act3

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var attack1Sound: MediaPlayer? = null
    private var attack2Sound: MediaPlayer? = null
    private var backgroundMusic: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundMusic = MediaPlayer.create(this, R.raw.background_music)
        backgroundMusic?.isLooping = true
        backgroundMusic?.setVolume(0.1f, 0.1f) // Lower volume for background music
        backgroundMusic?.start()

        val characterImageView = findViewById<ImageView>(R.id.characterImageView)
        val btnAttack1 = findViewById<Button>(R.id.btnAttack1)
        val btnAttack2 = findViewById<Button>(R.id.btnAttack2)
        val btnNextActivity = findViewById<Button>(R.id.btn3)

        attack1Sound = MediaPlayer.create(this, R.raw.attack1)
        attack2Sound = MediaPlayer.create(this, R.raw.attack2)

        // Setup idle animation
        fun setIdleAnimation() {
            characterImageView.setBackgroundResource(R.drawable.idle)
            val idleAnimation = characterImageView.background as AnimationDrawable
            idleAnimation.start()
        }

        // Initial idle animation
        setIdleAnimation()

        // Attack 1 button
        btnAttack1.setOnClickListener {
            attack1Sound?.start()
            characterImageView.setBackgroundResource(R.drawable.ataque1)
            val attackAnimation = characterImageView.background as AnimationDrawable
            attackAnimation.start()

            // Calculate total animation duration and return to idle
            var totalDuration = 0
            for (i in 0 until attackAnimation.numberOfFrames) {
                totalDuration += attackAnimation.getDuration(i)
            }

            Handler(Looper.getMainLooper()).postDelayed({
                setIdleAnimation()
            }, totalDuration.toLong())
        }

        // Attack 2 button
        btnAttack2.setOnClickListener {
            attack2Sound?.start()
            characterImageView.setBackgroundResource(R.drawable.ataque2)
            val attackAnimation = characterImageView.background as AnimationDrawable
            attackAnimation.start()

            // Calculate total animation duration and return to idle
            var totalDuration = 0
            for (i in 0 until attackAnimation.numberOfFrames) {
                totalDuration += attackAnimation.getDuration(i)
            }

            Handler(Looper.getMainLooper()).postDelayed({
                setIdleAnimation()
            }, totalDuration.toLong())
        }

        // Next activity button
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        attack1Sound?.release()
        attack2Sound?.release()
        backgroundMusic?.release()
    }
}