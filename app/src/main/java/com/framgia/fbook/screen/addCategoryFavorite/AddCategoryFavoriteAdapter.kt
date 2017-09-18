package com.framgia.fbook.screen.addCategoryFavorite

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Category
import com.framgia.fbook.databinding.ItemAddCategoryFavoriteBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter

/**
 * Created by levutantuan on 9/15/17.
 */
class AddCategoryFavoriteAdapter(
    context: Context) : BaseRecyclerViewAdapter<AddCategoryFavoriteAdapter.ItemViewHolder>(
    context) {
  private val mListCategory: MutableList<Category> = ArrayList()

  fun updateData(listCategory: List<Category>?) {
    mListCategory.clear()
    if (listCategory != null) {
      mListCategory.addAll(listCategory)
    }
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int = mListCategory.size

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<ItemAddCategoryFavoriteBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.item_add_category_favorite, parent, false)
    return ItemViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.binData(mListCategory[position])
  }

  inner class ItemViewHolder(
      private val mBinding: ItemAddCategoryFavoriteBinding) : RecyclerView.ViewHolder(
      mBinding.root) {
    fun binData(category: Category) {
      mBinding.viewModel = ItemAddCategoryFavoriteViewModel(category)
      mBinding.executePendingBindings()
    }
  }
}
