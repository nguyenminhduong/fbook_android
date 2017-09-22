package com.framgia.fbook.screen

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

/**
 * Created by Hyperion on 9/15/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
abstract class EndlessRecyclerOnScrollListener(
    private val mLayoutManager: RecyclerView.LayoutManager) : RecyclerView.OnScrollListener() {

  protected abstract fun onLoadMore(page: Int)

  private val visibleThreshold = 5

  private var loading = true
  private val startingPageIndex = 2

  companion object {
    private var currentPage = 1
    private var previousTotalItemCount = 0
    fun resetLoadMore() {
      currentPage = 1
      previousTotalItemCount = 0
    }
  }

  private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
    var maxSize = 0
    for (i in lastVisibleItemPositions.indices) {
      if (i == 0) {
        maxSize = lastVisibleItemPositions[i]
      } else if (lastVisibleItemPositions[i] > maxSize) {
        maxSize = lastVisibleItemPositions[i]
      }
    }
    return maxSize
  }


  override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)
    var lastVisibleItemPosition = 0
    val totalItemCount = mLayoutManager.itemCount
    when (mLayoutManager) {
      is StaggeredGridLayoutManager -> {
        val lastVisibleItemPositions = mLayoutManager.findLastVisibleItemPositions(null)
        lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
      }
      is GridLayoutManager -> lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()
      is LinearLayoutManager -> lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()
    }
    if (totalItemCount < previousTotalItemCount) {
      currentPage = this.startingPageIndex
      previousTotalItemCount = totalItemCount
      if (totalItemCount == 0) {
        this.loading = true
      }
    }
    if (loading && totalItemCount > previousTotalItemCount) {
      loading = false
      previousTotalItemCount = totalItemCount
    }
    if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
      currentPage++
      onLoadMore(currentPage)
      loading = true
    }
  }


}
