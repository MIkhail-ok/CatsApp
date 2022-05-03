package ru.mikhail.bochkarev.catsapp.data.remote

import retrofit2.http.GET
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto

interface CatApi {

	companion object {
		const val API_KEY = "4cdf9c81-12a7-4aec-a1fb-4ae2e8b11ec6"
		const val BASE_URL = "https://api.thecatapi.com"
	}

	@GET("/v1/images/search?limit=10")
	suspend fun loadCat(): List<CatDto>
}