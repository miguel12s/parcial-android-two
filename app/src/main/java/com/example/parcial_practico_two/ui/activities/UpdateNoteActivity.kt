package com.example.parcial_practico_two.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.parcial_practico_two.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_practico_two.data.model.NotaModel
import com.example.parcial_practico_two.ui.viewModels.NoteViewModel
import com.example.parcial_practico_two.utils.Common


class UpdateNoteActivity : AppCompatActivity() {
    private var tag:String="UpdateProfileActivity"
    private  var uid:Long = 0
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var tvcontenido: TextView
    private lateinit var tvtitulo: TextView
    private lateinit var btupdate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)
        tvcontenido = findViewById(R.id.tvupdatecontenido)
        tvtitulo = findViewById(R.id.tvupdatetitulo)
        btupdate=findViewById(R.id.btupdate)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        intent.getStringExtra("id_note").let {
            Log.d(tag,"it $it")
            if (it.isNullOrEmpty()) {
                Log.d(tag,"it $it")
                Common.showToast(this, "ocurrio un error al mostrar los datos de dicho usuario")
            } else {
                uid = it.toLong()
                noteViewModel.getNoteForIud(uid)

            }

        }
        noteViewModel.noteForUid.observe(this) { note ->
            tvtitulo.text = note.titulo
            tvcontenido.text = note.contenido


        }

        btupdate.setOnClickListener {
            val titulo = tvtitulo.text.toString()
            val contenido = tvcontenido.text.toString()
            if (titulo.isEmpty() || contenido.isEmpty()) {
                Common.showToast(this,"los campos no deben estar vacios")

            }else{
                noteViewModel.updateNote(titulo,contenido,uid)
                finish()
            }
        }



    }
}