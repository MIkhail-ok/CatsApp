package ru.mikhail.bochkarev.catsapp.presentation.cat_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.mapper.toCatListItemUiModel
import javax.inject.Inject

class CatListViewModel @Inject constructor(
	private val repository: CatRepository,
) : ViewModel() {

	private var _content = MutableLiveData<List<CatListItemUiModel>>()
	val content: LiveData<List<CatListItemUiModel>> = _content

	private var _isRefreshing = MutableLiveData(false)
	val isRefreshing: LiveData<Boolean> = _isRefreshing

	init {
		getCat(loadFromRemote = false)
	}

	fun refreshCats() {
		_isRefreshing.value = true
		getCat(loadFromRemote = true)
	}

	private fun getCat(loadFromRemote: Boolean) {
		viewModelScope.launch {
			val cats = async(Dispatchers.IO) {
				repository.getCat(
					loadFromRemote = loadFromRemote
				)
					.map { it.toCatListItemUiModel() }
			}
			_content.value = cats.await()
			_isRefreshing.value = false
		}
	}
}