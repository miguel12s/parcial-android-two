package com.example.parcial_practico_two.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.parcial_practico_two.R
import com.example.parcial_practico_two.utils.Common

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var button:Button
    private lateinit var tvcontenido: TextView
    private lateinit var tvtitulo: TextView
    private  var tag="ViewNoteActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)
        button=findViewById(R.id.back)
        tvcontenido = findViewById(R.id.tvviscontenido)
        tvtitulo = findViewById(R.id.tvvistitulo)
        intent.getStringExtra("contenido").let {
           tvcontenido.text=it

            }
        intent.getStringExtra("titulo").let {
            tvtitulo.text=it

        }


    button.setOnClickListener {
finish()

    }

    }

}