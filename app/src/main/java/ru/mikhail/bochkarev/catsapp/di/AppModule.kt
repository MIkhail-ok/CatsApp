package ru.mikhail.bochkarev.catsapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.mikhail.bochkarev.catsapp.data.local.CatsDatabase
import ru.mikhail.bochkarev.catsapp.data.remote.CatApi
import javax.inject.Singleton

@Module
object AppModule {

	@Provides
	@Singleton
	fun provideCatApi(): CatApi {
		return Retrofit.Builder()
			.baseUrl(CatApi.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create()
	}

	@Provides
	@Singleton
	fun provideCatsDatabase(appContext: Context): CatsDatabase {
		return Room.databaseBuilder(
			appContext,
			CatsDatabase::class.java,
			"catsdb.db"
		).build()
	}
}