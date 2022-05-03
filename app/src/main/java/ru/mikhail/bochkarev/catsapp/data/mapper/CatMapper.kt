package ru.mikhail.bochkarev.catsapp.data.mapper

import ru.mikhail.bochkarev.catsapp.data.local.CatEntity
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

fun CatDto.toCatModel(): CatModel = CatModel(imageUrl = url)

fun CatDto.toCatEntity(): CatEntity =
	CatEntity(
		id = id,
		imageUrl = url
	)

fun CatEntity.toCatModel(): CatModel = CatModel(imageUrl = imageUrl)