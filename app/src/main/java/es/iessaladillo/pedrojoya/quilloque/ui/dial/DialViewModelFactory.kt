import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallDao
import es.iessaladillo.pedrojoya.quilloque.ui.dial.DialViewModel

class DialViewModelFactory (private val repository: CallDao, private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DialViewModel::class.java!!)) {
            DialViewModel(this.repository, this.application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}