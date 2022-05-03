package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters

@Subcomponent(
	modules = [
		CatDetailsModule::class
	]
)
interface CatDetailsComponent {

	fun inject(activity: CatDetailsFragment)

	@Subcomponent.Factory
	interface Factory {

		fun create(
			@BindsInstance params: CatDetailsParameters,
		): CatDetailsComponent
	}
}

@Module
interface CatDetailsModule {

	@Binds
	@[IntoMap ViewModelKey(CatDetailsViewModel::class)]
	fun provideMainViewModel(viewModel: CatDetailsViewModel): ViewModel
}