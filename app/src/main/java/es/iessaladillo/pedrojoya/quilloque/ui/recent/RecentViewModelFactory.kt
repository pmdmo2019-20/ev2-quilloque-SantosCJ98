import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallDao
import es.iessaladillo.pedrojoya.quilloque.ui.recent.RecentViewModel

class RecentViewModelFactory (private val repository: CallDao, private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecentViewModel::class.java!!)) {
            RecentViewModel(this.repository, this.application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}