package ru.mikhail.bochkarev.catsapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.mikhail.bochkarev.catsapp.di.ViewModelKey

@Subcomponent(
	modules = [
		MainActivityModule::class
	]
)
interface MainActivityComponent {

	fun inject(activity: MainActivity)

	@Subcomponent.Factory
	interface Factory {

		fun create(): MainActivityComponent
	}
}

@Module
interface MainActivityModule {

	@Binds
	@[IntoMap ViewModelKey(MainActivityViewModel::class)]
	fun provideMainViewModel(viewModel: MainActivityViewModel): ViewModel
}