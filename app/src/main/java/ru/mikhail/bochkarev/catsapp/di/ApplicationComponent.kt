package ru.mikhail.bochkarev.catsapp.di

import dagger.Component
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.CatListComponent
import ru.mikhail.bochkarev.catsapp.presentation.main_screen.MainActivityComponent
import javax.inject.Singleton

@Component(
	modules = [
		ViewModelModule::class,
		NavigationModule::class
	]
)
@Singleton
interface ApplicationComponent {
	val mainActivityComponent: MainActivityComponent.Factory
	val catListComponent: CatListComponent.Factory
}