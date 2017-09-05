package com.framgia.fbook.screen.menuprofile

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.framgia.fbook.R

/**
 * Created by levutantuan on 9/5/17.
 */
class MenuProfileAdapter(private val context: Context,
    fragment: FragmentManager) : FragmentPagerAdapter(fragment) {
  companion object {
    val TOTAL_TAB: Int = 2
  }

  override fun getItem(position: Int): Fragment {
    return MenuProfileContainerFragment.newInstance(position)
  }

  override fun getPageTitle(position: Int): CharSequence {
    when (position) {
      MenuProfileContainerFragment.PROFILE -> return context.getString(R.string.personal_infor)
      MenuProfileContainerFragment.CATEGORY_FAVORITE -> return context.getString(
          R.string.category_favorite)
    }
    return ""
  }

  override fun getCount(): Int = TOTAL_TAB
}
