package ru.mikhail.bochkarev.catsapp.data.mapper

import ru.mikhail.bochkarev.catsapp.data.local.CatEntity
import ru.mikhail.bochkarev.catsapp.data.local.CatFavoritesEntity
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

fun CatDto.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = url,
		width = width,
		height = height,
	)

fun CatDto.toCatEntity(): CatEntity =
	CatEntity(
		id = id,
		imageUrl = url,
		width = width,
		height = height,
	)

fun CatEntity.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = imageUrl,
		width = width,
		height = height,
	)
fun CatModel.toCatFavoritesEntity(): CatFavoritesEntity =
	CatFavoritesEntity(
		id = id,
		imageUrl = imageUrl,
		width = width,
		height = height,
	)
fun CatFavoritesEntity.toCatModel(): CatModel =
	CatModel(
		id = id,
		imageUrl = imageUrl,
		width = width,
		height = height,
	)