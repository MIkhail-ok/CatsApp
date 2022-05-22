package ru.mikhail.bochkarev.catsapp.presentation.cat_list.adapter

import android.content.res.Resources
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.Resource
import ru.mikhail.bochkarev.catsapp.R
import ru.mikhail.bochkarev.catsapp.other.widgets.recyclerview.TypeOffsetItemDecoration
import ru.mikhail.bochkarev.catsapp.presentation.cat_list.model.CatListItemUiModel

class CatListDecoration(
    resources: Resources
): TypeOffsetItemDecoration() {
    private val offset8 = resources.getDimensionPixelOffset(R.dimen.offset8)
    private val offset16 = resources.getDimensionPixelOffset(R.dimen.offset16)

    override fun getItemOffsets(outRect: Rect, item: Any?, parent: RecyclerView) {
        when(item){
            is CatListItemUiModel -> outRect.set(offset8,offset8,offset8,offset8)
        }
    }
}