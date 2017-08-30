package com.framgia.fbook.screen.SearchBook

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.framgia.fbook.R

/**
 * Created by ThS on 8/29/2017.
 */
class SearchBookPagerAdapter(private val context: Context,
    fm: FragmentManager) : FragmentPagerAdapter(fm) {
  companion object {
    val TOTAL_TAB: Int = 2
  }

  override fun getItem(position: Int): Fragment {
    return SearchBookContainerFragment.newInstance(position)
  }

  override fun getPageTitle(position: Int): CharSequence {
    when (position) {
      SearchBookContainerFragment.INTERNAL_BOOK -> return context.getString(R.string.internal_book)
      SearchBookContainerFragment.GOOGLE_BOOK -> return context.getString(R.string.google_book)
    }
    return ""
  }

  override fun getCount(): Int = TOTAL_TAB

}
