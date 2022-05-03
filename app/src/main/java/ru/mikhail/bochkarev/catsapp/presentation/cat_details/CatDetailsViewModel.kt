package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import javax.inject.Inject

class CatDetailsViewModel @Inject constructor(
	private val repository: CatRepository,
) : ViewModel() {

	private var _content = MutableLiveData<List<Any>>()
	val content: LiveData<List<Any>> = _content
}