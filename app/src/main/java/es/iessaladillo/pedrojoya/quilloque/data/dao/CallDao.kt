package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call

@Dao
interface CallDao {

    @Insert
    fun insertCall(call: Call)

    @Update
    fun editCall(call: Call)

    @Delete
    fun deleteCall(call: Call)

    @Query("SELECT * FROM calls")
    fun queryAllCalls(): List<Call>

    @Query("SELECT * FROM calls WHERE numero LIKE :numero")
    fun queryCalls(numero: String): List<Call>

}