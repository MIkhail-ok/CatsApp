package ru.mikhail.bochkarev.catsapp.presentation.cat_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel
import javax.inject.Inject

class CatListViewModel @Inject constructor() : ViewModel() {

	private var _content = MutableLiveData<List<CatListItemUiModel>>()
	val content: LiveData<List<CatListItemUiModel>> = _content

	init {
		_content.value = listOf(
			CatListItemUiModel("https://upload.wikimedia.org/wikipedia/commons/4/4a/100x100_logo.png?20171226183928"),
			CatListItemUiModel("https://aloha-plus.ru/wp-content/uploads/2018/08/rabstol_net_elephant_07.jpg"),
			CatListItemUiModel("https://aloha-plus.ru/wp-content/uploads/2018/08/rabstol_net_elephant_07.jpg"),
			CatListItemUiModel("https://placepic.ru/wp-content/uploads/2018/11/photo_slonyat_07.jpg"),
			CatListItemUiModel("https://aloha-plus.ru/wp-content/uploads/2018/08/rabstol_net_elephant_07.jpg"),
			CatListItemUiModel("https://placepic.ru/wp-content/uploads/2018/11/photo_slonyat_07.jpg"),
			CatListItemUiModel("https://aloha-plus.ru/wp-content/uploads/2018/08/rabstol_net_elephant_07.jpg"),
		)
	}
}