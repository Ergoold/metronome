package com.example.metronome

import android.os.Bundle
import android.os.Handler
import android.view.SoundEffectConstants
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MetronomeActivity : AppCompatActivity() {
    private lateinit var bpm: EditText
    private lateinit var start: Button

    private var delay: Long = 0
    private var on = false

    private val handler = Handler()
    private val runnable = object : Runnable {
        override fun run() {
            start.playSoundEffect(SoundEffectConstants.CLICK)
            handler.postDelayed(this, delay)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metronome)

        bpm = findViewById(R.id.bpm)
        start = findViewById(R.id.start)

        start.setOnClickListener {
            if (!on) {
                delay = 60 * 1000 / bpm.text.toString().toLong()
                handler.postDelayed(runnable, delay)
            } else {
                handler.removeCallbacks(runnable)
            }

            on = !on
            start.text = getString(if (on) R.string.stop else R.string.start)
        }
    }
}