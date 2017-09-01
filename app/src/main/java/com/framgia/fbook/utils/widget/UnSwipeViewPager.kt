package com.framgia.fbook.utils.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by levutantuan on 8/31/17.
 */
class UnSwipeViewPager : ViewPager {
  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

  override fun onInterceptTouchEvent(arg0: MotionEvent): Boolean {
    return false
  }

  override fun canScrollHorizontally(direction: Int): Boolean {
    return false
  }

  override fun onTouchEvent(ev: MotionEvent): Boolean {
    return false
  }

  override fun setCurrentItem(item: Int) {
    super.setCurrentItem(item, false)
  }
}
