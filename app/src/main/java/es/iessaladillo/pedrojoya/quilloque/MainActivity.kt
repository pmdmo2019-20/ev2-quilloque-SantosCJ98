package es.iessaladillo.pedrojoya.quilloque

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import es.iessaladillo.pedrojoya.stroop.data.AppDatabase
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity()  {

    val db: AppDatabase by lazy {

        Room.databaseBuilder(this, AppDatabase::class.java, "app_database").build()

    }


    val navController: NavController by lazy {

        findNavController(R.id.navHostFragment)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()


    }

    private fun setupViews() {

        setupBNV()

        setupToolbar()


    }

    private fun setupBNV() {

        bottomNavigationView.setOnNavigationItemSelectedListener {

            if (it.itemId == R.id.mnuDial) {

                navController.navigate(R.id.dialDestination)

            }

           else if (it.itemId == R.id.mnuRecent) {

                navController.navigate(R.id.recentDestination)

            }

            else if (it.itemId == R.id.mnuContacts) {

                navController.navigate(R.id.contactsDestination)

            }

            true

        }

    }

    private fun setupToolbar() {

        toolbar.setupWithNavController(navController, AppBarConfiguration(navController.graph))

    }



}
