package ru.mikhail.bochkarev.catsapp.data.mapper

import ru.mikhail.bochkarev.catsapp.data.local.CatEntity
import ru.mikhail.bochkarev.catsapp.data.local.CatFavouritesEntity
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

fun CatDto.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = url,
		height = height,
		width = width,
	)

fun CatDto.toCatEntity(): CatEntity =
	CatEntity(
		id = id,
		imageUrl = url,
		height = height,
		width = width,
	)


fun CatEntity.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = imageUrl,
		height = height,
		width = width,
	)

fun CatModel.toCatFavouritesEntity(): CatFavouritesEntity =
	CatFavouritesEntity(
		id = id,
		imageUrl = imageUrl,
		height = height,
		width = width,
	)

fun CatFavouritesEntity.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = imageUrl,
		height = height,
		width = width,
	)