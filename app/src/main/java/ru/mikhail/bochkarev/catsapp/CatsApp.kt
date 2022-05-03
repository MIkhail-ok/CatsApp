package ru.mikhail.bochkarev.catsapp

import android.app.Application
import ru.mikhail.bochkarev.catsapp.di.DaggerApplicationComponent

class CatsApp : Application() {
	val appComponent = DaggerApplicationComponent
		.factory()
		.create(appContext = this)

	companion object {
		lateinit var instance: CatsApp
			private set
	}

	override fun onCreate() {
		super.onCreate()
		instance = this
	}
}