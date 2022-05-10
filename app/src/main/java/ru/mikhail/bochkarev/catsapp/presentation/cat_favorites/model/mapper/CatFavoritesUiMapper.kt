package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.mapper

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.model.CatFavoritesItemUiModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel

fun CatModel.toCatFavoritesItemUiModel(): CatFavoritesItemUiModel =
	CatFavoritesItemUiModel(
		id=id,
		imageUrl = imageUrl
	)