package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatFavoritesEntity(
    @PrimaryKey val id: String,
    val imageUrl: String,
    val width: Int,
    val height: Int,
)