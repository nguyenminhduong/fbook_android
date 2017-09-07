package com.framgia.fbook.screen.menuprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.categoryfavorite.CategoryFavoriteFragment
import com.framgia.fbook.screen.personalinfor.PersonalInforFragment
import com.framgia.fbook.utils.navigator.NavigateAnim
import com.framgia.fbook.utils.navigator.Navigator

/**
 * Created by levutantuan on 9/5/17.
 */

class MenuProfileContainerFragment : BaseFragment() {
  companion object {

    val EXTRA_TAB: String = "EXTRA_TAB"
    val PROFILE: Int = 0
    val CATEGORY_FAVORITE: Int = 1

    fun newInstance(position: Int): MenuProfileContainerFragment {
      var menuProfileContainerFragment: MenuProfileContainerFragment = MenuProfileContainerFragment()
      var bundle: Bundle = Bundle()
      bundle.putInt(EXTRA_TAB, position)
      menuProfileContainerFragment.arguments = bundle
      return menuProfileContainerFragment
    }
  }

  private val mNavigator: Navigator by lazy { Navigator(this) }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val view: View? = inflater?.inflate(R.layout.fragment_menu_profile_container, container, false)
    var containerId = R.id.layout_menu_profile_container
    var page: Int = arguments.getInt(EXTRA_TAB)
    when (page) {
      PROFILE -> mNavigator?.goNextChildFragment(containerId, PersonalInforFragment.newInstance(),
          false, NavigateAnim.NONE, PersonalInforFragment.TAG)
      CATEGORY_FAVORITE -> mNavigator.goNextChildFragment(containerId,
          CategoryFavoriteFragment.newInstance(), false, NavigateAnim.NONE,
          CategoryFavoriteFragment.TAG)
    }
    return view
  }
}
