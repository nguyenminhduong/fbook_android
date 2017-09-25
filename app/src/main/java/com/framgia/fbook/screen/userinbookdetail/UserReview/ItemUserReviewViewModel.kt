package com.framgia.fbook.screen.userinbookdetail.UserReview

import android.databinding.BaseObservable
import android.view.View
import com.framgia.fbook.data.model.Book

/**
 * Created by framgia on 22/09/2017.
 */
class ItemUserReviewViewModel(val reviewDetail: Book.ReviewDetail,
    private val itemUserReviewClickListener: ItemUserReviewClickListener?) : BaseObservable() {
  fun onItemUserReviewClick(view: View) {
    itemUserReviewClickListener?.onItemUserReviewClick(reviewDetail)
  }
}
