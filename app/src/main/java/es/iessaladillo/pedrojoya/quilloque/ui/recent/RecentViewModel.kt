package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import kotlin.concurrent.thread

class RecentViewModel(
    val callDao: CallDao, val
    application: Application
): ViewModel() {

val recents: MutableLiveData<List<Call>> = MutableLiveData(callDao.queryAllCalls())


}