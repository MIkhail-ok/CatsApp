package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import ru.mikhail.bochkarev.catsapp.presentation.Screens
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavouritesItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.mapper.toCatFavouritesItemUiModel
import javax.inject.Inject

class CatFavouritesViewModel @Inject constructor(
	private val repository: CatRepository,
	private val router: Router,
) : ViewModel() {

	private var _content = MutableLiveData<List<CatFavouritesItemUiModel>>()
	val content: LiveData<List<CatFavouritesItemUiModel>> = _content

	init {
		getCats()
	}

	fun onCatFavouritesClicked(uiModel: CatFavouritesItemUiModel) {
		val parameters = CatDetailsParameters(id = uiModel.id)
		router.navigateTo(Screens.CatDetails(parameters = parameters))
	}

	private fun getCats() {
		viewModelScope.launch {
			_content.value = repository.getAllFavouriteCats().map { it.toCatFavouritesItemUiModel() }
		}
	}
}