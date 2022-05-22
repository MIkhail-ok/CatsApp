package ru.mikhail.bochkarev.catsapp.presentation.main_screen

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.mikhail.bochkarev.catsapp.CatsApp
import ru.mikhail.bochkarev.catsapp.R
import ru.mikhail.bochkarev.catsapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	@Inject
	lateinit var navigatorHolder: NavigatorHolder

	private lateinit var viewModel: MainActivityViewModel
	private lateinit var binding: ActivityMainBinding

	private val navigator: Navigator = AppNavigator(this, R.id.vFragmentContainer)

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		val inflater: MenuInflater = menuInflater
		inflater.inflate(R.menu.cat_options_menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.cat_list -> {
				viewModel.onMenuCatListClicked()
				true
			}
			R.id.cat_favourites -> {
				viewModel.onMenuCatFavouritesClicked()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}

	override fun onResume() {
		super.onResume()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		navigatorHolder.removeNavigator()
		super.onPause()
	}

	private fun configureDI() {
		val mainComponent = CatsApp.instance.appComponent.mainActivityComponent.create()
		mainComponent.inject(this)
		viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
	}

}