package ru.mikhail.bochkarev.catsapp.presentation.cat_list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey

@Subcomponent(
	modules = [
		CatListModule::class
	]
)
interface CatListComponent {

	fun inject(activity: CatListFragment)

	@Subcomponent.Factory
	interface Factory {

		fun create(): CatListComponent
	}
}

@Module
interface CatListModule {

	@Binds
	@[IntoMap ViewModelKey(CatListViewModel::class)]
	fun provideMainViewModel(viewModel: CatListViewModel): ViewModel
}