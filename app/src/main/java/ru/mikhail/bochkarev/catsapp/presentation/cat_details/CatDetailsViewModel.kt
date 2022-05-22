package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper.toCatDetailsList
import javax.inject.Inject

class CatDetailsViewModel @Inject constructor(
	private val repository: CatRepository,
	private val parameter: CatDetailsParameters,
) : ViewModel() {

	private var _content = MutableLiveData<List<Any>>()
	val content: LiveData<List<Any>> = _content

	private var _isFavourite = MutableLiveData<Boolean>()
	val isFavourite: LiveData<Boolean> = _isFavourite

	var model: CatModel? = null

	init {
		gatCatDetails()
	}

	fun onFavouriteButtonClicked() {
		if (isFavourite.value == true) {
			deleteFromFavorite()
		} else {
			addToFavourite()
		}
	}

	private fun addToFavourite() {
		viewModelScope.launch {
			repository.addToFavourite(model ?: return@launch)
			checkIsFavourite()
		}
	}

	private fun deleteFromFavorite() {
		viewModelScope.launch {
			repository.deleteFromFavourite(model ?: return@launch)
			checkIsFavourite()
		}
	}

	private fun gatCatDetails() {
		viewModelScope.launch {
			model = repository.getCatById(id = parameter.id)
			checkIsFavourite()
			_content.value = model?.toCatDetailsList()
		}
	}

	private suspend fun checkIsFavourite() {
		_isFavourite.value = repository.isFavourite(model ?: return)
	}
}