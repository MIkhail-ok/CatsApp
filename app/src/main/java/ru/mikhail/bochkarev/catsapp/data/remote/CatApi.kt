package ru.mikhail.bochkarev.catsapp.data.remote

import retrofit2.http.GET
import ru.mikhail.bochkarev.catsapp.data.remote.dto.CatDto
import ru.mikhail.bochkarev.catsapp.domain.model.CatModel

interface CatApi {
    companion object{
        const val API_KEY = "fbb08314-f895-4ee7-acef-607cb54f6c00"
        const val BASE_URL = "https://api.thecatapi.com"
    }

    @GET("/v1/images/search?limit=10")
    suspend fun loadCat():List<CatDto>
}