package com.framgia.fbook.screen.approverequest

import android.databinding.BaseObservable
import com.framgia.fbook.data.model.Book

/**
 * Created by framgia on 22/09/2017.
 */
class ItemApproveRequestViewModel(val book: Book,
    private val mItemClickListener: ItemApproveRequestClickListener?) : BaseObservable() {
  fun onItemBookClicked() {
    mItemClickListener?.onItemClick(book)
  }

  fun onClickViewRequest() {
    mItemClickListener?.onClickViewRequest(book)
  }


}
