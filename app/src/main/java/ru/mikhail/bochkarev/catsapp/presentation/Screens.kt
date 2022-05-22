package ru.mikhail.bochkarev.catsapp.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.CatDetailsFragment
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.CatFavouritesFragment
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.CatListFragment

object Screens {

	fun CatList() = FragmentScreen { CatListFragment() }
	fun CatFavourites() = FragmentScreen { CatFavouritesFragment() }

	fun CatDetails(parameters: CatDetailsParameters) = FragmentScreen {
		CatDetailsFragment.getNewInstance(
			params = parameters
		)
	}
}