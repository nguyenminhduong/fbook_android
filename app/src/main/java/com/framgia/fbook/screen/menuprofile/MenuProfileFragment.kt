package com.framgia.fbook.screen.menuprofile

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.databinding.FragmentMenuProfileBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import com.framgia.fbook.screen.sharebook.ShareBookActivity
import com.framgia.fbook.utils.navigator.Navigator
import javax.inject.Inject

/**
 * Menuprofile Screen.
 */
class MenuProfileFragment : BaseFragment(), MenuProfileContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: MenuProfileContract.Presenter
  private val mNavigator: Navigator by lazy { Navigator(this) }
  @Inject
  lateinit var menuProfileAdapter: MenuProfileAdapter
  private lateinit var mMenuProfileComponent: MenuProfileComponent
  @Inject
  lateinit var mUserRepository: UserRepository
  var mUser: ObservableField<User> = ObservableField()

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
    mUser.set(mUserRepository.getUserLocal())
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

  fun onClickShareBook() {
    mNavigator.startActivity(ShareBookActivity::class.java)
  }

  fun onClickApproveRequest() {
    //Todo navigation Activity Approve Request
  }

  fun onClickSetting() {
    //Todo navigation Activity Setting
  }

  fun onClickLogout() {
    //Todo navigation Logout
  }
}
