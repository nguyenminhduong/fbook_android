package com.framgia.fbook.screen.bookdetail

import android.databinding.BaseObservable
import android.view.View
import com.framgia.fbook.data.model.User

/**
 * Created by framgia on 14/09/2017.
 */
class ItemUserViewModel(val mUser: User,
    private val mItemUserClickListener: ItemUserClickListener?) : BaseObservable() {
  fun onItemUserClick(view: View) {
    mItemUserClickListener?.onItemUserClick(mUser)
  }
}
