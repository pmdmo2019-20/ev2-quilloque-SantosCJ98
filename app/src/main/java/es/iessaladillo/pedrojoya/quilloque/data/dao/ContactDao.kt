package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun editContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun queryAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE nombre LIKE :nombre")
    fun queryContacts(nombre: String): LiveData<List<Contact>>

}