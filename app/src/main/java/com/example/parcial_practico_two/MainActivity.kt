package com.example.parcial_practico_two

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_practico_two.ui.activities.CreateActivity
import com.example.parcial_practico_two.ui.adapters.NoteAdapter
import com.example.parcial_practico_two.ui.viewModels.NoteViewModel
import com.example.parcial_practico_two.utils.Common

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttoncreate:Button
    private lateinit var buttonDelete:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvNotes)
buttoncreate=findViewById(R.id.btcrearnota)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.noteList.observe(this) { noteList ->
            Log.d(tag, "onCreate:$noteList")

            if (noteList != null) {
                Log.d(tag, "onCreate:$noteList")
                val adapter = NoteAdapter(noteList, ViewModelProvider(this) )
                recyclerView.adapter = adapter


            } else {
                Common.showToast(this, "hubo un error al obtener las notas")
            }


        }
        noteViewModel.getNotes()

        buttoncreate.setOnClickListener {
            val intent=Intent(this,CreateActivity::class.java)
            startActivity(intent)
//.setTextSize
        }

    }

    override fun onResume() {
        super.onResume()
        noteViewModel.getNotes()

    }
}