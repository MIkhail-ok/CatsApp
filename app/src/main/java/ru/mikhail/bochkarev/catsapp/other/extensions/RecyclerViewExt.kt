package ru.mikhail.bochkarev.catsapp.other.extensions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewHolder

fun RecyclerView.getItemByChild(child: View): Any? {
    return when (val holder = getChildViewHolder(child)) {
        is AdapterDelegateViewBindingViewHolder<*,*> -> holder.item
        is AdapterDelegateViewHolder<*> -> holder.item
        else -> null
    }
}