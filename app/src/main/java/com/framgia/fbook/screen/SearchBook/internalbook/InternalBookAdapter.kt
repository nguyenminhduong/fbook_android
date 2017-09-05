package com.framgia.fbook.screen.SearchBook.internalbook

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.databinding.FragmentInternalBookItemBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter

/**
 * Created by Hyperion on 9/5/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class InternalBookAdapter(
    context: Context) : BaseRecyclerViewAdapter<InternalBookAdapter.ItemViewHolder>(
    context) {

  private val mListBook = mutableListOf<Book>()
  private lateinit var mItemClickListener: ItemInternalBookListener

  fun updateData(listBook: List<Book>) {
    mListBook.clear()
    mListBook.addAll(listBook)
    notifyDataSetChanged()
  }

  fun setItemInternalBookListener(itemInternalBookListener: ItemInternalBookListener) {
    mItemClickListener = itemInternalBookListener
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.bindData(mListBook[position])
  }

  override fun getItemCount(): Int = mListBook.size

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<FragmentInternalBookItemBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.fragment_internal_book_item, parent, false)
    return ItemViewHolder(binding, mItemClickListener)
  }


  /**
   * ItemViewHolder
   */
  class ItemViewHolder(private val mBinding: FragmentInternalBookItemBinding,
      private val mItemClickListener: ItemInternalBookListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bindData(book: Book) {
      mBinding.viewModel = ItemInternalBookViewModel(book, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
