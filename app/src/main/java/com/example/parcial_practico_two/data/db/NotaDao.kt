package com.example.parcial_practico_two.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parcial_practico_two.data.model.NotaModel
@Dao
interface NotaDao {

    @Query("Select * from nota")
    fun getNotas(): List<NotaModel>

    @Query("select * from nota where uid=:uid")

    fun getNoteForUid(uid:Long):NotaModel
    @Insert
    fun insert(user: NotaModel):Long
    @Query("delete from nota where uid=:uid")
    fun delete(uid:Long?)


    @Update
    fun update(user:NotaModel):Int
}