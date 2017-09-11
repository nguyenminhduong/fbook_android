package com.framgia.fbook.screen.mainpage.adapter

import android.databinding.BaseObservable
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.screen.onItemRecyclerViewClickListener

/**
 * Created by Hyperion on 9/11/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class ItemMainPageViewModel(val book: Book,
    private val mItemClickListener: onItemRecyclerViewClickListener?) : BaseObservable() {

  fun onItemClicked() {
    mItemClickListener?.onItemClickListener(book)
  }
}
