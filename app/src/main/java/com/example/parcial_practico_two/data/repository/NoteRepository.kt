package com.example.parcial_practico_two.data.repository

import com.example.parcial_practico_two.data.db.AppDatabase
import com.example.parcial_practico_two.data.model.NotaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.content.Context

class NoteRepository(context:Context) {
    private val database = AppDatabase.getInstance(context)


    suspend fun updateNote(
        nota:NotaModel
    ):Int {
        return withContext(Dispatchers.IO) {
            database.NotaDao().update(
                nota)
        }
    }

    suspend fun getNotes(): List<NotaModel> {
        return withContext(Dispatchers.IO) {
            database.NotaDao().getNotas()
        }
    }



    suspend fun insertNote(nota: NotaModel): Boolean {
        return withContext(Dispatchers.IO) {
            val userId = database.NotaDao().insert(nota)
            userId.toInt() != 0

        }
    }

    suspend fun getNoteForUid(uid:Long): NotaModel {
        return withContext(Dispatchers.IO) {
            database.NotaDao().getNoteForUid(uid)

        }
    }
    suspend fun delete(uid:Long?): Long {
        return withContext(Dispatchers.IO) {
            database.NotaDao().delete(uid)

        }
    }
}