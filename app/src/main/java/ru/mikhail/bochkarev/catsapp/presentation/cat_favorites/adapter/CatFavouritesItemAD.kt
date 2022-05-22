package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.adapter

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemCatFavouritesBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavouritesItemUiModel


fun catFavouritesItemAD(
	onClick: (CatFavouritesItemUiModel) -> Unit,
) = adapterDelegateViewBinding<CatFavouritesItemUiModel, Any, ListItemCatFavouritesBinding>(
	{ layoutInflater, parent ->
		ListItemCatFavouritesBinding.inflate(layoutInflater, parent, false)
	}
) {

	binding.vImage.setOnClickListener { onClick(item) }

	bind {
		Glide.with(itemView)
			.load(item.imageUrl)
			.into(binding.vImage)
	}
}