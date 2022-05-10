package ru.mikhail.bochkarev.catsapp.data.repository

import ru.mikhail.bochkarev.catsapp.data.local.CatsDatabase
import ru.mikhail.bochkarev.catsapp.data.mapper.toCatEntity
import ru.mikhail.bochkarev.catsapp.data.mapper.toCatFavoritesEntity
import ru.mikhail.bochkarev.catsapp.data.mapper.toCatFavoritesEntity
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

	override suspend fun getCats(loadFromRemote: Boolean): List<CatModel> {

		val dbCats = dao.getCats()

		if (loadFromRemote || dbCats.isEmpty()) {
			val remoteCats = api.loadCat().map { it.toCatEntity() }
			dao.clearCats()
			dao.insertCats(remoteCats)
		}

		return dao.getCats().map { it.toCatModel() }
	}

	override suspend fun getCatById(id: String): CatModel {
		return dao.getCatById(id).firstOrNull()?.toCatModel() ?:
		dao.getFavoriteCat(id).first().toCatModel()

	}

	override suspend fun isFavorite(catModel: CatModel): Boolean {
		return dao.getFavoriteCat(catModel.id).isNotEmpty()
	}

	override suspend fun addFavorite(catModel: CatModel) {
		dao.insertFavoriteCat(catModel.toCatFavoritesEntity())
	}

	override suspend fun deleteFavorite(catModel: CatModel) {
		dao.deleteFavoriteCat(catModel.toCatFavoritesEntity())
	}

	override suspend fun getAllFavoriteCats(): List<CatModel> {
		return dao.getAllFavoriteCats().map { it.toCatModel() }
	}

}