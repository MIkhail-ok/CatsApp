package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey

@Subcomponent(
	modules = [
		CatFavouritesModule::class
	]
)
interface CatFavouritesComponent {

	fun inject(activity: CatFavouritesFragment)

	@Subcomponent.Factory
	interface Factory {

		fun create(): CatFavouritesComponent
	}
}

@Module
interface CatFavouritesModule {

	@Binds
	@[IntoMap ViewModelKey(CatFavouritesViewModel::class)]
	fun provideMainViewModel(viewModel: CatFavouritesViewModel): ViewModel
}