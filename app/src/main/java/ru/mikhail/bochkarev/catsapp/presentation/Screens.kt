package ru.mikhail.bochkarev.catsapp.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.CatListFragment

object Screens {

	fun CatList() = FragmentScreen { CatListFragment() }
}