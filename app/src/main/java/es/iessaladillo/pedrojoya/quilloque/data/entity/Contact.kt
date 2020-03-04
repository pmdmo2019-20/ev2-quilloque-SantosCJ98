package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val idCont: Long,
    val nombre: String,
    val numero: String
)