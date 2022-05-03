package ru.mikhail.bochkarev.catsapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.mikhail.bochkarev.catsapp.data.remote.CatApi
import java.security.AccessControlContext
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideCatApi():CatApi{
        return Retrofit.Builder()
            .baseUrl(CatApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}