package com.framgia.fbook.screen.sharebook

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.databinding.ItemImageSelectedBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter

class ImageSelectedAdapter(
    context: Context) : BaseRecyclerViewAdapter<ImageSelectedAdapter.ItemViewHolder>(
    context) {

  val mListImage = mutableListOf<BookRequest.Image>()
  private lateinit var mItemClickListener: ItemImageSelectedListener

  fun updateData(listImage: List<BookRequest.Image>) {
    mListImage.addAll(listImage)
    if (mListImage.isNotEmpty()) {
      mListImage[0].type = 1
    }
    notifyDataSetChanged()
  }

  fun removeOneItem(image: BookRequest.Image) {
    mListImage.remove(image)
    if (mListImage.isNotEmpty()) {
      mListImage[0].type = 1
    }
    notifyDataSetChanged()
  }

  fun setItemImageSelectedListener(itemInternalBookListener: ItemImageSelectedListener) {
    mItemClickListener = itemInternalBookListener
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.bindData(mListImage[position])
  }

  override fun getItemCount(): Int = mListImage.size

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<ItemImageSelectedBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.item_image_selected, parent, false)
    return ItemViewHolder(binding, mItemClickListener)
  }

  /**
   * ItemViewHolder
   */
  class ItemViewHolder(private val mBinding: ItemImageSelectedBinding,
      private val mItemClickListener: ItemImageSelectedListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bindData(image: BookRequest.Image) {
      mBinding.viewModel = ItemImageSelectedViewModel(image, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
