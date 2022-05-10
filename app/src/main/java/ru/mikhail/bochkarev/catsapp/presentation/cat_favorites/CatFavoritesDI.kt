package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey

@Subcomponent(
	modules = [
		CatFavoritesModel::class
	]
)
interface CatFavoritesComponent {

	fun inject(activity: CatFavoritesFragment)

	@Subcomponent.Factory
	interface Factory {

		fun create(): CatFavoritesComponent
	}
}

@Module
interface CatFavoritesModel {

	@Binds
	@[IntoMap ViewModelKey(CatFavoritesViewModel::class)]
	fun provideMainViewModel(viewModel: CatFavoritesViewModel): ViewModel
}