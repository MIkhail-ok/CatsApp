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
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper.toCatDetailsImageUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavoritesItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.mapper.toCatFavoritesItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.mapper.toCatListItemUiModel
import javax.inject.Inject

class CatFavoritesViewModel @Inject constructor(
	private val repository: CatRepository,
	private val router:Router
) : ViewModel() {

	private var _content = MutableLiveData<List<CatFavoritesItemUiModel>>()
	val content: LiveData<List<CatFavoritesItemUiModel>> = _content

	init {
		getCat(loadFromRemote = false)
	}

	fun onCatFavoritesClicked(uiModel: CatFavoritesItemUiModel){
		val parameters=CatDetailsParameters(id=uiModel.id)
		router.navigateTo(Screens.CatDetails(parameters=parameters))
	}

	private fun getCat(loadFromRemote: Boolean) {
		viewModelScope.launch{
			_content.value=repository.getAllFavoriteCats().map { it.toCatFavoritesItemUiModel() }
		}
	}
}