package ru.mikhail.bochkarev.catsapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CatDto (
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
)