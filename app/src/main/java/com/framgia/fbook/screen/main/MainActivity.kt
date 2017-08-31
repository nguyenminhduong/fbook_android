package com.framgia.fbook.screen.main

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.view.View
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivityMainBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.screen.SearchBook.SearchBookActivity
import com.framgia.fbook.screen.login.LoginActivity
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.navigator.Navigator
import com.framia.fbook.screen.main.MainContract
import com.roughike.bottombar.BottomBar
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.ViewModel {

  @Inject
  lateinit var presenter: MainContract.Presenter
  @Inject
  lateinit var mNavigator: Navigator
  @Inject
  lateinit var mAdapter: MainContainerPagerAdapter
  lateinit var mMainComponent: MainComponent
  val mCurrentTab: ObservableField<Int> = ObservableField()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mMainComponent = DaggerMainComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .mainModule(MainModule(this))
        .build()
    mMainComponent.inject(this)

    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    binding.viewModel = this
    onSelectItemMenu()
  }

  override fun onStart() {
    super.onStart()
    presenter.onStart()
  }

  override fun onStop() {
    presenter.onStop()
    super.onStop()
  }

  fun setCurrentTab(tab: Int) {
    mCurrentTab.set(tab)
  }


  fun onSelectItemMenu() {
    val bottomBar = findViewById(R.id.bottom_navigation) as BottomBar
    bottomBar.setOnTabSelectListener {
      idView ->
      when (idView) {
        R.id.tab_home -> setCurrentTab(Constant.Tab.TAB_HOME)
        R.id.tab_my_book -> setCurrentTab(Constant.Tab.TAB_MY_BOOK)
        R.id.tab_notification -> setCurrentTab(Constant.Tab.TAB_NOTIFICATION)
        R.id.tab_account -> setCurrentTab(Constant.Tab.TAB_ACCOUNT)
      }
    }
  }

  fun onClickSearch(view: View) {
    mNavigator.startActivity(SearchBookActivity::class.java)
  }

  fun onClickChooseDomain(view: View) {
    //Todo dev later
  }

  fun getMainComponent(): MainComponent {
    return mMainComponent
  }

  fun onClickLogin(view: View) {
    mNavigator.startActivity(LoginActivity::class.java)
  }
}
