package ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.mapper

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsImageUiModel
import ru.mikhail.bochkarev.catsapp.presentation.common.model.TextUiModel
fun CatModel.toCatDetailsList():List<Any>{
    val list = mutableListOf<Any>()

    list += this.toCatDetailsImageUiModel()

    list += TextUiModel(
        text = "Height: ${this.height}"
    )
    list += TextUiModel(
        text = "Width: ${this.width}"
    )

    return list
}

fun CatModel.toCatDetailsImageUiModel():CatDetailsImageUiModel =
    CatDetailsImageUiModel(
        imageUrl = imageUrl
    )

