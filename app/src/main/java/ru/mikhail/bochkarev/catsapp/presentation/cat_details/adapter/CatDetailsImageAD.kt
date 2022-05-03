package ru.mikhail.bochkarev.catsapp.presentation.cat_details.adapter

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemCatDetailsImageBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemCatListBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsImageUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel


fun catDetailsImageAD(
) = adapterDelegateViewBinding<CatDetailsImageUiModel, Any, ListItemCatDetailsImageBinding>(
	{ layoutInflater, parent ->
		ListItemCatDetailsImageBinding.inflate(layoutInflater, parent, false)
	}
) {

	bind {
		Glide.with(itemView)
			.load(item.imageUrl)
			.into(binding.vImage)
	}
}