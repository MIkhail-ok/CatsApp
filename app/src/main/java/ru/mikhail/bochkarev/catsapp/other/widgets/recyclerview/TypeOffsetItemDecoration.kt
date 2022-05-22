package ru.mikhail.bochkarev.catsapp.other.widgets.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.mikhail.bochkarev.catsapp.other.extensions.getItemByChild

abstract class TypeOffsetItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val item = parent.getItemByChild(view)
        getItemOffsets(outRect, item, parent)
    }

    protected abstract fun getItemOffsets(outRect: Rect, item: Any?, parent: RecyclerView)
}