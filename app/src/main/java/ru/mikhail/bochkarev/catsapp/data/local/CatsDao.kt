package ru.mikhail.bochkarev.catsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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
}