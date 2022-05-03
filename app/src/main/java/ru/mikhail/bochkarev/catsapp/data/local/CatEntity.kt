package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatEntity(
	@PrimaryKey val id: String,
	val imageUrl: String,
)