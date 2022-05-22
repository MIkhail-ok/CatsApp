package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface CatsDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertCats(cats: List<CatEntity>)

	@Query("SELECT * FROM catentity")
	suspend fun getCats(): List<CatEntity>

	@Query("DELETE FROM catentity")
	suspend fun clearCats()

	@Query("SELECT * FROM catentity WHERE id == :id")
	suspend fun getCatById(id: String): List<CatEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertFavouriteCat(cat: CatFavouritesEntity)

	@Query("SELECT * FROM catfavouritesentity WHERE id == :id")
	suspend fun getFavouriteCat(id: String): List<CatFavouritesEntity>

	@Query("SELECT * FROM catfavouritesentity")
	fun getAllFavouritesCats(): Flow<List<CatFavouritesEntity>>

	@Delete
	suspend fun deleteFavouriteCat(cat: CatFavouritesEntity)
}