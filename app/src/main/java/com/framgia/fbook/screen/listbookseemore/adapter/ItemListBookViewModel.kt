package com.framgia.fbook.screen.listbookseemore.adapter

import android.databinding.BaseObservable
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/13/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class ItemListBookViewModel(val book: Book,
    private val mItemClickListener: onItemRecyclerViewClickListener?) : BaseObservable() {

  fun onItemClicked() {
    mItemClickListener?.onItemClickListener(book)
  }
}
