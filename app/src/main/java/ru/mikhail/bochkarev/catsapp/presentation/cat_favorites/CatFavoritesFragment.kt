package ru.mikhail.bochkarev.catsapp.presentation.cat_favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import ru.mikhail.bochkarev.catsapp.CatsApp
import ru.mikhail.bochkarev.catsapp.databinding.FragmentCatFavoritesBinding
import ru.mikhail.bochkarev.catsapp.databinding.FragmentCatListBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_favorites.adapter.CatFavoritesAdapter
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.adapter.CatListAdapter
import javax.inject.Inject

class CatFavoritesFragment : Fragment() {

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	private var _binding: FragmentCatFavoritesBinding? = null
	private val binding get() = _binding!!

	private lateinit var viewModel: CatFavoritesViewModel

	private val adapter by lazy {
		CatFavoritesAdapter(
			onCatItemClick = viewModel::onCatFavoritesClicked
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		_binding = FragmentCatFavoritesBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initUi()
		initContentList()
		observeViewModel()
	}

	private fun observeViewModel() {
		viewModel.content.observe(viewLifecycleOwner) { content ->
			adapter.items = content
		}
	}

	private fun initUi() {
	}

	private fun initContentList() {
		binding.vContent.adapter = adapter
		val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
		binding.vContent.layoutManager = layoutManager
	}

	private fun configureDI() {
		val component = CatsApp.instance.appComponent.catFavoritesComponent.create()
		component.inject(this)
		viewModel = ViewModelProvider(this, viewModelFactory)[CatFavoritesViewModel::class.java]
	}
}