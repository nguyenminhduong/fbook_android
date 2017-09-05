package com.framgia.fbook.screen.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

/**
 * Created by levutantuan on 8/30/17.
 */
class MainContainerPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

  private lateinit var mCurrentFragment: Fragment

  override fun getItem(position: Int): Fragment? {
    return MainContainerFragment.newInstance(position)
  }

  override fun getCount(): Int {
    return TOTAL_TAB
  }

  override fun setPrimaryItem(container: ViewGroup?, position: Int, currentFragment: Any) {
    mCurrentFragment = currentFragment as Fragment
    super.setPrimaryItem(container, position, currentFragment)
  }

  fun getCurrentFragment(): Fragment {
    return mCurrentFragment
  }

  companion object {
    private val TOTAL_TAB = 4
  }
}
