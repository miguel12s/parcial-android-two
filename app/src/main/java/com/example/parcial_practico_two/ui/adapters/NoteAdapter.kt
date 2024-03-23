package com.example.parcial_practico_two.ui.adapters


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_practico_two.R

import com.example.parcial_practico_two.data.model.NotaModel
import com.example.parcial_practico_two.ui.activities.UpdateNoteActivity
import com.example.parcial_practico_two.ui.activities.ViewNoteActivity
import com.example.parcial_practico_two.ui.viewModels.NoteViewModel

class NoteAdapter(private val noteList: List<NotaModel>,private val viewmodel:ViewModelProvider) :
    RecyclerView.Adapter<NoteAdapter.UserViewHolder>() {
        private val tag = "UserAdapter"

        class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(nota: NotaModel) {
                itemView.findViewById<TextView>(R.id.tvcardtitulo).text = nota.titulo
                itemView.findViewById<TextView>(R.id.tvcarddescripcion).text = nota.contenido?.substring(0,10)+"..."


            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_note, parent, false)
            return UserViewHolder(view)
        }

        override fun getItemCount(): Int {
            Log.d(tag, "getItemCount:${noteList.size}")
            return noteList.size

        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            val note = noteList[position]
            holder.bind(note)
            holder.itemView.findViewById<Button>(R.id.bteliminarcard).setOnClickListener {

               val noteViewModel = viewmodel.get(NoteViewModel::class.java)
noteViewModel.deleteNote(note?.uid)

            }
            holder.itemView.findViewById<Button>(R.id.bteditarcard).setOnClickListener{
                    v:View->
                val intent= Intent(v.context,UpdateNoteActivity::class.java)
                intent.putExtra("id_note",note.uid.toString())
                v.context.startActivity(intent)
            }

            holder.itemView.findViewById<TextView>(R.id.tvcardtitulo).setOnClickListener {

                val intent= Intent(it.context,ViewNoteActivity::class.java)

                intent.putExtra("contenido",note.contenido.toString())
                intent.putExtra("titulo",note.titulo.toString())
                intent.putExtra("id_note",note.uid?.toLong())
                it.context.startActivity(intent)


            }


        }

        }
