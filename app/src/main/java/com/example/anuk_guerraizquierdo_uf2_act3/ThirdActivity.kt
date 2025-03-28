package com.example.anuk_guerraizquierdo_uf2_act3

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager

class ThirdActivity : AppCompatActivity() {
    private var isLeft = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val button = findViewById<Button>(R.id.btnToggle)
        val rootLayout = findViewById<ConstraintLayout>(R.id.rootLayout)

        button.setOnClickListener {
            val constraintSet = ConstraintSet()
            constraintSet.clone(rootLayout)

            if (isLeft) {
                constraintSet.clear(R.id.btnToggle, ConstraintSet.START)
                constraintSet.connect(R.id.btnToggle, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 32)
            } else {
                constraintSet.clear(R.id.btnToggle, ConstraintSet.END)
                constraintSet.connect(R.id.btnToggle, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 32)
            }

            TransitionManager.beginDelayedTransition(rootLayout)
            constraintSet.applyTo(rootLayout)

            isLeft = !isLeft
        }
    }
}
