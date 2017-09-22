package com.framgia.fbook.screen.userinbookdetail

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.screen.userinbookdetail.screen.UserReview.UserReviewFragment
import com.framgia.fbook.utils.Constant

/**
 * Created by framgia on 21/09/2017.
 */
class UserInBookDetailAdapter(private val context: Context,
    fragmentManager: FragmentManager, private val mBook: Book) : FragmentPagerAdapter(
    fragmentManager) {

  companion object {
    val TOTAL_TAB: Int = 5
  }

  override fun getItem(position: Int): Fragment {
    when (position) {
      Constant.TabUser.TAB_USER_REVIEW -> return UserReviewFragment.newInstance(mBook)

    //TODO edit later
      Constant.TabUser.TAB_USER_WAITING -> return UserReviewFragment.newInstance(mBook)
      Constant.TabUser.TAB_USER_READING -> return UserReviewFragment.newInstance(mBook)
      Constant.TabUser.TAB_USER_RETURNING -> return UserReviewFragment.newInstance(mBook)
      Constant.TabUser.TAB_USER_RETURNED -> return UserReviewFragment.newInstance(mBook)
    }
    return Fragment()
  }

  override fun getPageTitle(position: Int): CharSequence {
    when (position) {
      Constant.TabUser.TAB_USER_REVIEW -> return context.getString(R.string.user_review)
      Constant.TabUser.TAB_USER_WAITING -> return context.getString(R.string.user_waiting)
      Constant.TabUser.TAB_USER_READING -> return context.getString(R.string.user_reading)
      Constant.TabUser.TAB_USER_RETURNING -> return context.getString(R.string.user_returning)
      Constant.TabUser.TAB_USER_RETURNED -> return context.getString(R.string.user_returned)
    }
    return ""
  }

  override fun getCount(): Int = UserInBookDetailAdapter.TOTAL_TAB
}
