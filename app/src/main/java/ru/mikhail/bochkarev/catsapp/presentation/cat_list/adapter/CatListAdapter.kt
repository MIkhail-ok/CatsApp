package ru.mikhail.bochkarev.catsapp.presentation.cat_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel
import kotlin.jvm.internal.Intrinsics

class CatListAdapter(
	onCatItemClick: (CatListItemUiModel) -> Unit,
) : AsyncListDifferDelegationAdapter<Any>(DiffCallback) {

	init {
		delegatesManager
			.addDelegate(catListItemAD(onCatItemClick))
	}

	private companion object DiffCallback : DiffUtil.ItemCallback<Any>() {

		override fun areItemsTheSame(oldItem: Any, newItem: Any) = when {
			else -> oldItem.javaClass == newItem.javaClass
		}

		override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
			return Intrinsics.areEqual(oldItem, newItem)
		}
	}
}