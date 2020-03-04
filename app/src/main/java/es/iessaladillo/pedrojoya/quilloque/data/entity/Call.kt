package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "calls")
data class Call(
    @PrimaryKey(autoGenerate = true)
    val idCall: Long,
    val nombre: String,
    val numero: String,
    val fecha: String,
    val hora: String,
    val tipo: String
)