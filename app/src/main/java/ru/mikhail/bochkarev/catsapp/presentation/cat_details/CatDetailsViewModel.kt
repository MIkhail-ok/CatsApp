package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper.toCatDetailsImageUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper.toCatDetailsList
import javax.inject.Inject

class CatDetailsViewModel @Inject constructor(
	private val repository: CatRepository,
	private val parameter: CatDetailsParameters,
) : ViewModel() {

	private var _content = MutableLiveData<List<Any>>()
	val content: LiveData<List<Any>> = _content

	private var _isFavorite = MutableLiveData<Boolean>()
	val isFavorite: LiveData<Boolean> = _isFavorite

	var model: CatModel? = null

	init {
		gatCtaDetails()
	}

	fun onFavoriteButtonClicked(){
		if (isFavorite.value==true){
			deleteFromFavorite()
		}else{
			addToFavorite()
		}
	}

	private fun addToFavorite(){
		viewModelScope.launch {
			repository.addFavorite(model ?: return@launch)
			chekIsFavorite()
		}

	}

	private fun deleteFromFavorite(){
		viewModelScope.launch {
			repository.deleteFavorite(model ?: return@launch)
			chekIsFavorite()
		}

	}

	private fun gatCtaDetails(){
		viewModelScope.launch {
			model = repository.getCatById(id = parameter.id)
			chekIsFavorite()
			_content.value = model?.toCatDetailsList()

		}
	}

	private fun chekIsFavorite(){
		viewModelScope.launch {
			_isFavorite.value=repository.isFavorite(model ?: return@launch)

		}
	}
}