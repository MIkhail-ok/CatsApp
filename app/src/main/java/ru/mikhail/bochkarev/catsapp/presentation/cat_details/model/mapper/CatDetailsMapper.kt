package ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsImageUiModel

fun CatModel.toCatDetailsImageUiModel():CatDetailsImageUiModel =
    CatDetailsImageUiModel(
        imageUrl = imageUrl
    )