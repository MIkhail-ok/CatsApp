package ru.mikhail.bochkarev.catsapp.presentation.cat_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mikhail.bochkarev.catsapp.CatsApp
import ru.mikhail.bochkarev.catsapp.databinding.FragmentCatDetailsBinding
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.adapter.CatDetailsAdapter
import ru.mikhail.bochkarev.catsapp.presentation.cat_details.model.CatDetailsParameters
import javax.inject.Inject

class CatDetailsFragment : Fragment() {
	companion object{
		private const val EXTRA_PARAMS = "extra_params"

		fun getNewInstance(params: CatDetailsParameters):CatDetailsFragment{
			return CatDetailsFragment().apply {
				arguments=Bundle().apply {
					putParcelable(EXTRA_PARAMS,params)
				}
			}
		}
	}

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	private var _binding: FragmentCatDetailsBinding? = null
	private val binding get() = _binding!!

	private lateinit var viewModel: CatDetailsViewModel

	private val adapter by lazy {
		CatDetailsAdapter()
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
		_binding = FragmentCatDetailsBinding.inflate(inflater, container, false)
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
		val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
		binding.vContent.layoutManager = layoutManager
	}

	private fun configureDI() {
		val params = requireArguments().getParcelable<CatDetailsParameters>(EXTRA_PARAMS)
		val component = CatsApp.instance.appComponent.catDetailsComponent.create(
			requireNotNull(params)
		)
		component.inject(this)
		viewModel = ViewModelProvider(this, viewModelFactory)[CatDetailsViewModel::class.java]
	}
}