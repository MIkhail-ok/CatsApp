package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatFavouritesEntity(
	@PrimaryKey val id: String,
	val imageUrl: String,
	val height: Int,
	val width: Int,
)