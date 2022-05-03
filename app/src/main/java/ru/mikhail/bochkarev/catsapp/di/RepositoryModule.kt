package ru.mikhail.bochkarev.catsapp.di

import dagger.Binds
import dagger.Module
import ru.mikhail.bochkarev.catsapp.data.repository.CatRepositoryImpl
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

	@Binds
	@Singleton
	abstract fun bindsCatRepository(
		catRepositoryImpl: CatRepositoryImpl,
	): CatRepository
}