package ru.mikhail.bochkarev.catsapp.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
	private val cicerone = Cicerone.create()

	@Provides
	@Singleton
	fun provideCicerone(): Cicerone<Router> = cicerone

	@Provides
	@Singleton
	fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

	@Provides
	@Singleton
	fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder =
		cicerone.getNavigatorHolder()
}