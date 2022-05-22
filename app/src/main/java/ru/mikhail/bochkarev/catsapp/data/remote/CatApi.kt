package ru.mikhail.bochkarev.catsapp.data.remote

import retrofit2.http.GET
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto

interface CatApi {

	companion object {
		const val BASE_URL = "https://api.thecatapi.com"
	}

	@GET("/v1/images/search?limit=10")
	suspend fun loadCat(): List<CatDto>
}