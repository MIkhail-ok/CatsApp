package ru.mikhail.bochkarev.catsapp.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

	@Binds
	internal abstract fun bindViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory

}