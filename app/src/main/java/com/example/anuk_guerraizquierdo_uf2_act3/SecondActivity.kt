package com.example.anuk_guerraizquierdo_uf2_act3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnAnimate = findViewById<Button>(R.id.btnAnimate)
        btnAnimate.setOnClickListener {
            val motionLayout = findViewById<androidx.constraintlayout.motion.widget.MotionLayout>(R.id.motionLayout)
            motionLayout.transitionToEnd()
        }

        val motionLayout = findViewById<androidx.constraintlayout.motion.widget.MotionLayout>(R.id.motionLayout)
        motionLayout.setTransitionListener(object : androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: androidx.constraintlayout.motion.widget.MotionLayout?, startId: Int, endId: Int) {}
            override fun onTransitionChange(motionLayout: androidx.constraintlayout.motion.widget.MotionLayout?, startId: Int, endId: Int, progress: Float) {}
            override fun onTransitionCompleted(motionLayout: androidx.constraintlayout.motion.widget.MotionLayout?, currentId: Int) {
                // Cambiar a la tercera actividad después de la animación
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                startActivity(intent)
            }
            override fun onTransitionTrigger(motionLayout: androidx.constraintlayout.motion.widget.MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {}
        })
    }
}