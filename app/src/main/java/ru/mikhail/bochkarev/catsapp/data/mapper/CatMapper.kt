package ru.mikhail.bochkarev.catsapp.data.mapper

import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

fun CatDto.toCatModel():CatModel=CatModel(imageUrl=url)