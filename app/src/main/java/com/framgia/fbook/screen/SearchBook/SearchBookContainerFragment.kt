package com.framgia.fbook.screen.SearchBook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.SearchBook.googlebook.GoogleBookFragment
import com.framgia.fbook.screen.SearchBook.internalbook.InternalBookFragment
import com.framgia.fbook.utils.navigator.NavigateAnim
import com.framgia.fbook.utils.navigator.Navigator

/**
 * A simple [Fragment] subclass.
 */
class SearchBookContainerFragment : BaseFragment() {

  companion object {
    val TAG: String = "SearchBookContainerFragment"
    val INTERNAL_BOOK: Int = 0
    val GOOGLE_BOOK: Int = 1
    fun newInstance(position: Int): SearchBookContainerFragment {
      var searchBookContainerFragment: SearchBookContainerFragment = SearchBookContainerFragment()
      var bundle: Bundle = Bundle()
      bundle.putInt(TAG, position)
      searchBookContainerFragment.arguments = bundle
      return searchBookContainerFragment
    }
  }

  private val mNavigator: Navigator by lazy { Navigator(this) }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val view: View? = inflater?.inflate(R.layout.fragment_seach_book_container, container, false)
    var containerId = R.id.layout_search_book_container
    var page: Int = arguments.getInt(TAG)
    when (page) {
      INTERNAL_BOOK -> mNavigator.goNextChildFragment(containerId,
          InternalBookFragment.newInstance(),
          false, NavigateAnim.NONE, InternalBookFragment.TAG)
      GOOGLE_BOOK -> mNavigator.goNextChildFragment(containerId, GoogleBookFragment.newInstance(),
          false, NavigateAnim.NONE, GoogleBookFragment.TAG)

    }

    return view
  }
}
