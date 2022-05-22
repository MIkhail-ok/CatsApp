package ru.mikhail.bochkarev.catsapp.domain.repository

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

interface CatRepository {

	suspend fun getCats(loadFromRemote: Boolean): List<CatModel>
	suspend fun getCatById(id: String): CatModel

	suspend fun isFavourite(catModel: CatModel): Boolean
	suspend fun addToFavourite(catModel: CatModel)
	suspend fun deleteFromFavourite(catModel: CatModel)
	suspend fun getAllFavouriteCats(): List<CatModel>
}