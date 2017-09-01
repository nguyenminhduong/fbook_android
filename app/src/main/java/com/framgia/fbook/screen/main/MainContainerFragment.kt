package com.framgia.fbook.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.framgia.fbook.R
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.mybook.MyBookFragment
import com.framgia.fbook.screen.notification.NotificationFragment
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.navigator.NavigateAnim
import com.framgia.fbook.utils.navigator.Navigator

/**
 * Created by levutantuan on 8/30/17.
 */
class MainContainerFragment : BaseFragment() {

  private val mNavigator: Navigator by lazy { Navigator(this) }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val view = inflater?.inflate(R.layout.fragment_main_container, container, false)
    val tab = arguments.getInt(EXTRA_TAB_FOOTER)
    val containerId = R.id.layout_content_main
    when (tab) {
    //Todo navigation when click Tab Home
      Constant.Tab.TAB_HOME -> Toast.makeText(activity, R.string.home, Toast.LENGTH_SHORT).show()
      Constant.Tab.TAB_MY_BOOK -> mNavigator.goNextChildFragment(containerId,
          MyBookFragment.newInstance(), true, NavigateAnim.NONE, MyBookFragment.TAG)
      Constant.Tab.TAB_NOTIFICATION -> mNavigator.goNextChildFragment(containerId,
          NotificationFragment.newInstance(), true, NavigateAnim.NONE, MyBookFragment.TAG)
    //Todo navigation when click Tab Account
      Constant.Tab.TAB_ACCOUNT -> Toast.makeText(activity, R.string.account,
          Toast.LENGTH_SHORT).show()
    }
    return view
  }

  companion object {

    private val EXTRA_TAB_FOOTER = "EXTRA_TAB_FOOTER"

    fun newInstance(tab: Int): MainContainerFragment {
      val fragment = MainContainerFragment()
      val bundle = Bundle()
      bundle.putInt(EXTRA_TAB_FOOTER, tab)
      fragment.arguments = bundle
      return fragment
    }
  }
}
