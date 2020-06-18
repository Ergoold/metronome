package com.example.metronome

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MetronomeActivity : AppCompatActivity() {
    lateinit var bpm: EditText
    lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metronome)

        bpm = findViewById(R.id.bpm)
        start = findViewById(R.id.start)
    }
}