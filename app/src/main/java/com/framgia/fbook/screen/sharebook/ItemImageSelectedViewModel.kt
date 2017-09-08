package com.framgia.fbook.screen.sharebook

import android.databinding.BaseObservable
import com.framgia.fbook.data.source.remote.api.request.BookRequest

class ItemImageSelectedViewModel(val image: BookRequest.Image,
    private val mItemClickListener: ItemImageSelectedListener?) : BaseObservable() {

  fun onClickRemoveSelected() {
    mItemClickListener?.onRemoveSelected(image)
  }

  fun getImage(): String = image.image!!.toURI().toString()
}
