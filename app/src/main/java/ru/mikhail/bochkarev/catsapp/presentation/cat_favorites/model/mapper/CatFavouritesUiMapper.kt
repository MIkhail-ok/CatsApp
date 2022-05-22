package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.mapper

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavouritesItemUiModel

fun CatModel.toCatFavouritesItemUiModel(): CatFavouritesItemUiModel =
	CatFavouritesItemUiModel(
		id = id,
		imageUrl = imageUrl
	)