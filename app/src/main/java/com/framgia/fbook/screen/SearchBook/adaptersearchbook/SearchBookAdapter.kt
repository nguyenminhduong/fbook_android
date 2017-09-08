package com.framgia.fbook.screen.SearchBook.adaptersearchbook

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.GoogleBook
import com.framgia.fbook.databinding.FragmentGooglebookItemBinding
import com.framgia.fbook.databinding.FragmentInternalBookItemBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter
import com.framgia.fbook.screen.SearchBook.TypeSearch
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/5/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class SearchBookAdapter(
    context: Context) : BaseRecyclerViewAdapter<RecyclerView.ViewHolder>(
    context) {

  private val mListBook = mutableListOf<Book>()
  private val mListGoogleBook = mutableListOf<GoogleBook>()
  private lateinit var mItemClickListener: onItemRecyclerViewClickListener
  private var mTypeSearch: Int? = null

  fun updateData(listBook: List<Book>, type: Int) {
    mTypeSearch = type
    mListBook.clear()
    mListBook.addAll(listBook)
    notifyDataSetChanged()
  }

  fun updateDataGoogleBook(listBook: List<GoogleBook>, type: Int) {
    mTypeSearch = type
    mListGoogleBook.clear()
    mListGoogleBook.addAll(listBook)
    notifyDataSetChanged()
  }

  fun setItemInternalBookListener(itemInternalBookListener: onItemRecyclerViewClickListener) {
    mItemClickListener = itemInternalBookListener
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    if (mTypeSearch == TypeSearch.INTERNAL_BOOK) {
      val itemViewHolderInternalBook: ItemViewHolderInternalBook = holder as ItemViewHolderInternalBook
      itemViewHolderInternalBook.bindData(mListBook[position])
    }
    if (mTypeSearch == TypeSearch.GOOGLE_BOOK) {
      val itemViewHolderGoogleBook: ItemViewHolderGoogleBook = holder as ItemViewHolderGoogleBook
      itemViewHolderGoogleBook.bindData(mListGoogleBook[position])
    }
  }

  override fun getItemCount(): Int {
    when (mTypeSearch) {
      TypeSearch.INTERNAL_BOOK -> return mListBook.size
      TypeSearch.GOOGLE_BOOK -> return mListGoogleBook.size
    }
    return 0
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
    if (mTypeSearch == TypeSearch.INTERNAL_BOOK) {
      val binding = DataBindingUtil.inflate<FragmentInternalBookItemBinding>(
          LayoutInflater.from(parent?.context),
          R.layout.fragment_internal_book_item, parent, false)
      return ItemViewHolderInternalBook(
          binding, mItemClickListener)
    }
    val binding = DataBindingUtil.inflate<FragmentGooglebookItemBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.fragment_googlebook_item, parent, false)
    return ItemViewHolderGoogleBook(
        binding, mItemClickListener)
  }


  /**
   * ItemViewHolderInternal
   */
  class ItemViewHolderInternalBook(private val mBinding: FragmentInternalBookItemBinding,
      private val mItemClickListener: onItemRecyclerViewClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bindData(book: Book) {
      mBinding.viewModel = ItemSearchBookViewModel(
          book, null, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }

  /**
   * ItemViewHolderGoogle
   */
  class ItemViewHolderGoogleBook(private val mBinding: FragmentGooglebookItemBinding,
      private val mItemClickListener: onItemRecyclerViewClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bindData(book: GoogleBook) {
      mBinding.viewModel = ItemSearchBookViewModel(
          null, book, mItemClickListener)
      mBinding.executePendingBindings()
    }
  }
}
