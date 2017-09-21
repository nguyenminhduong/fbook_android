package com.framgia.fbook.screen.addCategoryFavorite

import android.databinding.BaseObservable
import android.view.View
import com.framgia.fbook.data.model.Category

/**
 * Created by levutantuan on 9/15/17.
 */
class ItemAddCategoryFavoriteViewModel(val category: Category,
    private val mItemCategoryListener: ItemClickSelectCategoryListener?) : BaseObservable() {
  fun onItemClickCategory(view: View) {
    mItemCategoryListener?.onItemCategoryClick(category)
  }
}
