package ru.mikhail.bochkarev.catsapp.domain.repository

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

interface CatRepository {

	suspend fun getCats(loadFromRemote: Boolean): List<CatModel>
	suspend fun getCatById(id:String): CatModel
}