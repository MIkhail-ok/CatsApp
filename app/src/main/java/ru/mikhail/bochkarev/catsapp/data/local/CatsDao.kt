package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.*

@Dao
interface CatsDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertCats(cats: List<CatEntity>)

	@Query("SELECT * FROM catentity")
	suspend fun getCats(): List<CatEntity>

	@Query("DELETE FROM catentity")
	suspend fun clearCats()

	@Query("SELECT * FROM catentity WHERE id == :id")
	suspend fun getCatById(id:String): List<CatEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertFavoriteCat(cat: CatFavoritesEntity)

	@Query("SELECT * FROM catfavoritesentity WHERE id == :id")
	suspend fun getFavoriteCat(id:String): List<CatFavoritesEntity>

	@Query("SELECT * FROM catfavoritesentity")
	suspend fun getAllFavoriteCats(): List<CatFavoritesEntity>

	@Delete
	suspend fun deleteFavoriteCat(cat: CatFavoritesEntity)
}