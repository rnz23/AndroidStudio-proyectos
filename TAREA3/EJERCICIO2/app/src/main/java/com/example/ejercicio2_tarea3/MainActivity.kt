package com.example.ejercicio2_tarea3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
import android.widget.Button
class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private var isPaused: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        mediaPlayer = MediaPlayer.create(this, R.raw.duki)

        // Reproducir
        btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                if (isPaused) {
                    mediaPlayer.start()  // continuar si estaba pausado
                    isPaused = false
                } else {
                    mediaPlayer.start()  // reproducir desde el inicio
                }
            }
        }
        // Pausar
        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                isPaused = true
            }
        }


        // Detener
        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying || isPaused) {
                mediaPlayer.stop()
                mediaPlayer.release() // liberar recursos
                mediaPlayer = MediaPlayer.create(this, R.raw.duki) // volver a inicializar
                isPaused = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release() // liberar memoria si se cierra la app
        }


    }
}