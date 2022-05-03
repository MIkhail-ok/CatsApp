package ru.mikhail.bochkarev.catsapp.presentation.cat_details.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatDetailsParameters (
    val id:String,
):Parcelable