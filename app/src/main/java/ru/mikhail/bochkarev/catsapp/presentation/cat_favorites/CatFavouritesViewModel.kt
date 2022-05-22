package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites

import androidx.lifecycle.*
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

	//private var _content = MutableLiveData<List<CatFavouritesItemUiModel>>()
	val content: LiveData<List<CatFavouritesItemUiModel>> = getCats().asLiveData()

	init {
		getCats()
	}

	fun onCatFavouritesClicked(uiModel: CatFavouritesItemUiModel) {
		val parameters = CatDetailsParameters(id = uiModel.id)
		router.navigateTo(Screens.CatDetails(parameters = parameters))
	}

	private fun getCats():Flow<List<CatFavouritesItemUiModel>> {
		return repository
			.getAllFavouriteCats()
			.map { list ->list.map { it.toCatFavouritesItemUiModel() } }
		}
	}