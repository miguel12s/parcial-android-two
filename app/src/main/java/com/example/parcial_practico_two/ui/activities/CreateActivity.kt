package com.example.parcial_practico_two.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_practico_two.R
import com.example.parcial_practico_two.ui.viewModels.NoteViewModel
import androidx.lifecycle.Observer
import com.example.parcial_practico_two.data.model.NotaModel
import com.example.parcial_practico_two.utils.Common


class CreateActivity : AppCompatActivity() {
    private lateinit var tvtitulo: TextView
    private lateinit var tvcontenido: TextView
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var btnregister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        btnregister=findViewById(R.id.btregister)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        tvtitulo=findViewById(R.id.tvtitulo)
        tvcontenido=findViewById(R.id.tvcontenido)
        noteViewModel.noteSaved.observe(this, Observer { isValidRegister ->
            if (isValidRegister) {
                Log.d("activity","$isValidRegister")
            } else {
                Common.showToast(this, "Hubo un error al registrar datos en la base de datos")

            }
        })
        btnregister.setOnClickListener {
            val titulo = tvtitulo.text.toString()
            val contenido = tvcontenido.text.toString()
            if (titulo.isEmpty() || contenido.isEmpty()) {
                Common.showToast(this,"los campos no deben estar vacios")

            }else{
                val note=NotaModel(null,titulo,contenido)
                noteViewModel.insertNote(note)
               finish()
            }
        }

    }


}