package ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.mapper

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel

fun CatModel.toCatListItemUiModel(): CatListItemUiModel =
	CatListItemUiModel(
		imageUrl = imageUrl
	)