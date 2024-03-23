package com.example.parcial_practico_two.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial_practico_two.data.model.NotaModel
import com.example.parcial_practico_two.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application)



    private val _noteSaved = MutableLiveData<Boolean>()
    val noteSaved: LiveData<Boolean>
        get() = _noteSaved



    private val _noteList = MutableLiveData<List<NotaModel>>()
    val noteList: LiveData<List<NotaModel>>
        get() = _noteList



    private val _noteForUid= MutableLiveData<NotaModel>()

    val noteForUid: LiveData<NotaModel>
        get()=_noteForUid




    private val _updateNote = MutableLiveData<Int>()

    val updateNote: LiveData<Int>
        get()=_updateNote

    val _deleteNote=MutableLiveData<Int>()
    val deleteNote: LiveData<Int>
        get()=_deleteNote
    fun insertNote(new_note:NotaModel) {
        viewModelScope.launch {
            val note = noteRepository.insertNote(new_note)
            _noteSaved.value = note
        }
    }
fun deleteNote(uid:Long?){
    viewModelScope.launch {
        noteRepository.delete(uid)


    }
}
    fun getNotes(){
        viewModelScope.launch {
            val notes = noteRepository.getNotes()
            _noteList.value = notes
        }
    }

    fun getNoteForIud(uid:Long){
        viewModelScope.launch {
            val note=noteRepository.getNoteForUid(uid)
            _noteForUid.value=note
        }
    }




    fun updateNote(    titulo:String,
                       contenido:String,
                       uid: Long){
        viewModelScope.launch {
            val note=NotaModel(uid,titulo,contenido)
            val iduserupdate=noteRepository.updateNote(note)
            Log.d("userviewModel","data $iduserupdate")
            _updateNote.value=iduserupdate
        }
    }
}