package com.framgia.fbook.screen.bookdetail

import android.databinding.BaseObservable
import android.view.View
import com.framgia.fbook.data.model.Owner

/**
 * Created by framgia on 14/09/2017.
 */
class ItemOwnerViewModel(val mOwner: Owner,
    private val mItemOwnerClickListener: ItemOwnerClickListener?) : BaseObservable() {
  fun onItemOwnerClick(view: View) {
    mItemOwnerClickListener?.onItemOwnerClick(mOwner)
  }
}
