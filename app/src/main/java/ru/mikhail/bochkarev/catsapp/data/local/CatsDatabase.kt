package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [
		CatEntity::class,
		CatFavoritesEntity::class,
	],
	version = 1
)
abstract class CatsDatabase : RoomDatabase() {
	abstract val dao: CatsDao
}