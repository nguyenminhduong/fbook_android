package com.framgia.fbook.screen.listbookseemore.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.databinding.FragmentListbookItemBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/13/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class ListBookAdapter(context: Context) : BaseRecyclerViewAdapter<ListBookAdapter.ItemViewHolder>(
    context) {
  private lateinit var mItemClickListener: onItemRecyclerViewClickListener
  private val mListBook = mutableListOf<Book>()

  fun updateData(listBook: List<Book>?, isBookNormal: Boolean) {
    if (!isBookNormal) {
      mListBook.clear()
    }
    listBook?.let {
      mListBook.addAll(listBook)
      notifyDataSetChanged()
    }
  }

  fun setItemInternalBookListener(itemInternalBookListener: onItemRecyclerViewClickListener) {
    mItemClickListener = itemInternalBookListener
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.binData(mListBook[position])
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<FragmentListbookItemBinding>(
        LayoutInflater.from(parent?.context), R.layout.fragment_listbook_item, parent,
        false)
    return ItemViewHolder(binding, mItemClickListener)
  }

  override fun getItemCount(): Int = mListBook.size

  inner class ItemViewHolder(private val mBinding: FragmentListbookItemBinding,
      private val mItemClickListener: onItemRecyclerViewClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun binData(book: Book) {
      mBinding.viewModel = ItemListBookViewModel(book, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
