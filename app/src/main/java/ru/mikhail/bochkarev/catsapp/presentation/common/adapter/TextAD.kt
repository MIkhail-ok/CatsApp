package ru.mikhail.bochkarev.catsapp.presentation.common.adapter

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemTextBinding
import ru.mikhail.bochkarev.catsapp.presentation.common.model.TextUiModel

fun textAD(
) = adapterDelegateViewBinding<TextUiModel, Any, ListItemTextBinding>(
	{ layoutInflater, parent ->
		ListItemTextBinding.inflate(layoutInflater, parent, false)
	}
) {

	bind {
		binding.vText.text = item.text
	}
}