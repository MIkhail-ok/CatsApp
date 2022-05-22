package ru.mikhail.bochkarev.catsapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.mikhail.bochkarev.catsapp.presentation.Screens
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
	private val router: Router,
) : ViewModel() {

	init {
		router.newRootScreen(Screens.CatList())
	}

	fun onMenuCatListClicked() {
		router.newRootScreen(Screens.CatList())
	}

	fun onMenuCatFavouritesClicked() {
		router.newRootScreen(Screens.CatFavourites())
	}
}