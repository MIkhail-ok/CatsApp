package ru.mikhail.bochkarev.catsapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.mikhail.bochkarev.catsapp.presentation.Screens
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
	router: Router,
) : ViewModel() {

	init {
		router.newRootScreen(Screens.CatList())
	}
}