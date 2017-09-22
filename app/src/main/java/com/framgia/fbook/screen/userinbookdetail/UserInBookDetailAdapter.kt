package com.framgia.fbook.screen.userinbookdetail

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.framgia.fbook.R
import com.framgia.fbook.utils.Constant

/**
 * Created by framgia on 21/09/2017.
 */
class UserInBookDetailAdapter(private val context: Context,
    fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

  companion object {
    val TOTAL_TAB: Int = 5
  }

  private val mFragments: MutableList<Fragment> = ArrayList<Fragment>()

  init {
    for (i in 0 until UserInBookDetailAdapter.TOTAL_TAB) {
      mFragments.add(Fragment())
    }
  }

  override fun getItem(position: Int): Fragment {
    //TODO edit later
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

  fun getFragment(position: Int?): Fragment? {
    try {
      return position?.let { mFragments[it] }
    } catch (e: IndexOutOfBoundsException) {
      return null
    }
  }
}
