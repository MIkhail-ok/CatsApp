package ru.mikhail.bochkarev.catsapp.domain.repository

import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

interface CatRepository {

	suspend fun getCat(loadFromRemote: Boolean): List<CatModel>
}