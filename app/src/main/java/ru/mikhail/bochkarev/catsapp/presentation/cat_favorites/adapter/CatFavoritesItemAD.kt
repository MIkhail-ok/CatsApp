package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.adapter

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.mikhail.bochkarev.catsapp.databinding.ListItemCatListBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavoritesItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel


fun catFavoritestemAD(
	onClick: (CatFavoritesItemUiModel) -> Unit,
) = adapterDelegateViewBinding<CatFavoritesItemUiModel, Any, ListItemCatListBinding>(
	{ layoutInflater, parent ->
		ListItemCatListBinding.inflate(layoutInflater, parent, false)
	}
) {

	binding.vImage.setOnClickListener{onClick(item)}

	bind {
		Glide.with(itemView)
			.load(item.imageUrl)
			.into(binding.vImage)
	}
}