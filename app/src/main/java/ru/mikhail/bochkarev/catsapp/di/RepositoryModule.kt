package ru.mikhail.bochkarev.catsapp.di

import dagger.Binds
import dagger.Module
import ru.mikhail.bochkarev.catsapp.data.repository.CatRepositoryImpl
import ru.mikhail.bochkarev.catsapp.domain.repository.CatRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun  bindsCatRepository(
        catRepository: CatRepositoryImpl,
    ):CatRepository
}