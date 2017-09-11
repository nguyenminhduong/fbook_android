package com.framgia.fbook.screen.mainpage.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.databinding.FragmentMainpageItemBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/11/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class MainPageTopRatingAdapter(
    context: Context) : BaseRecyclerViewAdapter<MainPageTopRatingAdapter.ItemViewHolder>(context) {
  private lateinit var mItemClickListener: onItemRecyclerViewClickListener
  private val mListBook = mutableListOf<Book>()

  fun updateData(listBook: List<Book>?) {
    listBook?.let {
      mListBook.addAll(it)
      notifyDataSetChanged()
    }
  }

  fun setItemInternalBookListener(itemInternalBookListener: onItemRecyclerViewClickListener) {
    mItemClickListener = itemInternalBookListener
  }

  override fun getItemCount(): Int = mListBook.size

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<FragmentMainpageItemBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.fragment_mainpage_item, parent, false)
    return ItemViewHolder(binding, mItemClickListener)
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.binData(mListBook[position])
  }

  inner class ItemViewHolder(
      private val mBinding: FragmentMainpageItemBinding,
      private val mItemClickListener: onItemRecyclerViewClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {
    fun binData(book: Book) {
      mBinding.viewModel = ItemMainPageViewModel(book, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
