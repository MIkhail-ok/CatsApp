package ru.mikhail.bochkarev.catsapp.data.repository

import ru.mikhail.bochkarev.catsapp.data.mapper.toCatModel
import ru.mikhail.bochkarev.catsapp.data.remote.CatApi
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
	private val api: CatApi,
) : CatRepository {

	override suspend fun getCat(): List<CatModel> {
		return api.loadCat().map { it.toCatModel() }
	}
}