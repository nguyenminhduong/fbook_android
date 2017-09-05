package com.framgia.fbook.screen.menuprofile

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentMenuProfileBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import com.framgia.fbook.utils.navigator.Navigator
import javax.inject.Inject

/**
 * Menuprofile Screen.
 */
class MenuProfileFragment : BaseFragment() {

  @Inject
  internal lateinit var mPresenter: MenuProfileContract.Presenter
  private val mNavigator: Navigator by lazy { Navigator(this) }
  @Inject
  lateinit var mMenuProfileAdapter: MenuProfileAdapter
  private lateinit var mMenuProfileComponent: MenuProfileComponent
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerMenuProfileComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .menuProfileModule(MenuProfileModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentMenuProfileBinding>(inflater,
        R.layout.fragment_menu_profile, container, false)
    binding.viewModel = this
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  companion object {
    val TAG: String = "MenuProfileFragment"
    fun newInstance(): MenuProfileFragment {
      return MenuProfileFragment()
    }
  }

  fun getMenuProfileComponent(): MenuProfileComponent {
    return mMenuProfileComponent
  }

  fun onClickArrow() {
    mNavigator.goBackChildFragment()
  }

  fun onClickShareBook() {
    //Todo navigation Activity Share Book
  }

  fun onClickApproveRequest() {
    //Todo navigation Activity Approve Request
  }

  fun onClickSetting() {
    //Todo navigation Activity Setting
  }
}
