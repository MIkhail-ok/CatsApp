package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey

@Subcomponent(
	modules = [
		CatDetailsModule::class
	]
)
interface CatDetailsComponent {

	fun inject(activity: CatDetailsFragment)

	@Subcomponent.Factory
	interface Factory {

		fun create(): CatDetailsComponent
	}
}

@Module
interface CatDetailsModule {

	@Binds
	@[IntoMap ViewModelKey(CatDetailsViewModel::class)]
	fun provideMainViewModel(viewModel: CatDetailsViewModel): ViewModel
}