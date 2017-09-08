package com.framgia.fbook.screen.SearchBook.adaptersearchbook

import android.databinding.BaseObservable
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.GoogleBook
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/5/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class ItemSearchBookViewModel(val book: Book?, val googleBook: GoogleBook?,
    private val mItemClickListener: onItemRecyclerViewClickListener?) : BaseObservable() {

  fun onItemClicked() {
    mItemClickListener?.onItemClickListener(book)
    mItemClickListener?.onItemClickListener(googleBook)
  }
}
