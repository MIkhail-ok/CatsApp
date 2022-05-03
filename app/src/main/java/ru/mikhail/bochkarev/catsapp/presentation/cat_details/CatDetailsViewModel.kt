package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper.toCatDetailsImageUiModel
import javax.inject.Inject

class CatDetailsViewModel @Inject constructor(
	private val repository: CatRepository,
	private val parameter: CatDetailsParameters,
) : ViewModel() {

	private var _content = MutableLiveData<List<Any>>()
	val content: LiveData<List<Any>> = _content

	init {
		gatCtaDetails()
	}

	private fun gatCtaDetails(){
		viewModelScope.launch {
			val catImage = repository.getCatById(id = parameter.id).toCatDetailsImageUiModel()
			_content.value = listOf(catImage)

		}

	}
}