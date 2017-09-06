package com.framgia.fbook.screen.mybook

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.databinding.ItemListMyBookBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter

/**
 * Created by framgia on 06/09/2017.
 */
class MyBookAdapter constructor(context: Context,
    books: List<Book>?) : BaseRecyclerViewAdapter<MyBookAdapter.ItemViewHolder>(context) {

  private val mBooks: MutableList<Book> = ArrayList<Book>()
  private val mItemMyBookListener: ItemMyBookClickListener

  init {
    if (books != null) {
      mBooks.addAll(books)
    }
    if (context !is ItemMyBookClickListener) {
      throw RuntimeException("Activity use this Adapter must implement ItemMyBookClickListener")
    }
    mItemMyBookListener = context;
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<ItemListMyBookBinding>(
        LayoutInflater.from(parent.context),
        R.layout.item_list_my_book, parent, false)
    return ItemViewHolder(binding, mItemMyBookListener)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    holder.bind(mBooks[position])
  }

  override fun getItemCount(): Int {
    return mBooks.size
  }

  class ItemViewHolder(private val mBinding: ItemListMyBookBinding,
      private val mItemClickListener: ItemMyBookClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bind(book: Book) {
      mBinding.viewModel = ItemMyBookViewModel(book, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
