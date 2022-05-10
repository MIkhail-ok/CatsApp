package ru.mikhail.bochkarev.catsapp.domain.repository

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

interface CatRepository {

	suspend fun getCats(loadFromRemote: Boolean): List<CatModel>
	suspend fun getCatById(id:String): CatModel

	suspend fun isFavorite(catModel: CatModel):Boolean
	suspend fun addFavorite(catModel: CatModel)
	suspend fun deleteFavorite(catModel: CatModel)
	suspend fun getAllFavoriteCats(): List<CatModel>
}