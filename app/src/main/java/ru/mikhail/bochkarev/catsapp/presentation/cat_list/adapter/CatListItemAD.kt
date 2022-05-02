package ru.mikhail.bochkarev.catsapp.presentation.cat_list.adapter

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemCatListBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel


fun catListItemAD(
) = adapterDelegateViewBinding<CatListItemUiModel, Any, ListItemCatListBinding>(
	{ layoutInflater, parent ->
		ListItemCatListBinding.inflate(layoutInflater, parent, false)
	}
) {
	bind {
		Glide.with(itemView)
			.load(item.imageUrl)
			.into(binding.vImage)
	}
}