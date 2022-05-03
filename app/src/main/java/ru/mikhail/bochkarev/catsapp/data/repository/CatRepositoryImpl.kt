package ru.mikhail.bochkarev.catsapp.data.repository

import ru.mikhail.bochkarev.catsapp.data.local.CatsDatabase
import ru.mikhail.bochkarev.catsapp.data.mapper.toCatEntity
import ru.mikhail.bochkarev.catsapp.data.mapper.toCatModel
import ru.mikhail.bochkarev.catsapp.data.remote.CatApi
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
	private val api: CatApi,
	private val database: CatsDatabase,
) : CatRepository {

	private val dao = database.dao

	override suspend fun getCat(loadFromRemote: Boolean): List<CatModel> {

		val dbCats = dao.getCats()

		if (loadFromRemote || dbCats.isEmpty()) {
			val remoteCats = api.loadCat().map { it.toCatEntity() }
			dao.clearCats()
			dao.insertCats(remoteCats)
		}

		return dao.getCats().map { it.toCatModel() }
	}
}