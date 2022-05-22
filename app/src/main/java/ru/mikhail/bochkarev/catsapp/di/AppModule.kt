package ru.mikhail.bochkarev.catsapp.di

import android.content.Context
import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
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
	fun provideCatApi(context: Context): CatApi {

		val interceptor = HttpLoggingInterceptor()
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

		val httpClient = OkHttpClient.Builder()
		httpClient.addInterceptor(Interceptor { chain ->
			val request: Request =
				chain.request().newBuilder().addHeader("x-api-key", "fbb08314-f895-4ee7-acef-607cb54f6c00").build()
			chain.proceed(request)
		})
		httpClient.addInterceptor(interceptor)
		httpClient.addInterceptor(ChuckerInterceptor.Builder(context).build())

		return Retrofit.Builder()
			.baseUrl(CatApi.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.client(httpClient.build())
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