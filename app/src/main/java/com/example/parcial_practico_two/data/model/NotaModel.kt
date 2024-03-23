package com.example.parcial_practico_two.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nota")

data class NotaModel(

    @PrimaryKey(autoGenerate = true)
    val uid: Long? = null,
    @ColumnInfo(name = "titulo")
    val titulo: String?,
    @ColumnInfo(name = "password")
    val contenido: String?
)