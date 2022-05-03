package ru.mikhail.bochkarev.catsapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.CatDetailsComponent
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.CatListComponent
import ru.mikhail.bochkarev.catsapp.presentation.main_screen.MainActivityComponent
import javax.inject.Singleton

@Component(
	modules = [
		ViewModelModule::class,
		NavigationModule::class,
		AppModule::class,
		RepositoryModule::class
	]
)
@Singleton
interface ApplicationComponent {
	val mainActivityComponent: MainActivityComponent.Factory
	val catListComponent: CatListComponent.Factory
	val catDetailsComponent: CatDetailsComponent.Factory

	@Component.Factory
	interface Factory {

		fun create(
			@BindsInstance appContext: Context,
		): ApplicationComponent
	}
}