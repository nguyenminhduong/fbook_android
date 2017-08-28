package com.framgia.fbook.screen.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivityMainBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import com.framia.fbook.screen.main.MainContract
import com.roughike.bottombar.BottomBar
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.ViewModel {

  @Inject
  lateinit var presenter: MainContract.Presenter
  @Inject
  lateinit var navigator: Navigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerMainComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .mainModule(MainModule(this))
        .build()
        .inject(this)

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

  fun onSelectItemMenu() {
    val bottomBar = findViewById(R.id.bottom_navigation) as BottomBar
    bottomBar.setOnTabSelectListener { i ->
      when (i) {
      //Todo Edit later -> Fragment Home
        R.id.tab_home -> Toast.makeText(applicationContext, R.string.home, Toast.LENGTH_LONG).show()
      //Todo Edit later -> Fragment My Book
        R.id.tab_my_book -> Toast.makeText(applicationContext, R.string.my_book,
            Toast.LENGTH_LONG).show()
      //Todo Edit later -> Fragment Notification
        R.id.tab_notification -> Toast.makeText(applicationContext, R.string.notification,
            Toast.LENGTH_SHORT).show()
      //Todo Edit later -> Fragment Account
        R.id.tab_account -> Toast.makeText(applicationContext, R.string.account,
            Toast.LENGTH_SHORT).show()
      }
    }
  }

  fun onClickSearch(view: View) {
    //Todo dev later
  }

  fun onClickChooseDomain(view: View) {
    //Todo dev later
  }

  fun onClickLogin(view: View) {
    //Todo dev later
  }
}
