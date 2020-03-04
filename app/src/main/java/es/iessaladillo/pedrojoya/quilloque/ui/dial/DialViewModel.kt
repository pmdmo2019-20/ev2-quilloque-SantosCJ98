package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import kotlin.concurrent.thread

class DialViewModel(
    val callDao: CallDao, val
    application: Application
): ViewModel() {

    val calls: MutableLiveData<String> = MutableLiveData("")

    var number: String = ""

    fun queryCalls(number: String): List<Call> {

            return callDao.queryCalls(number)

    }

    fun insertCall(call: Call) {

        callDao.insertCall(call)

    }


}