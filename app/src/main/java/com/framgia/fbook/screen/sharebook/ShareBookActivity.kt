package com.framgia.fbook.screen.sharebook

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivitySharebookBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import javax.inject.Inject

/**
 * ShareBook Screen.
 */
class ShareBookActivity : BaseActivity(), ShareBookContract.ViewModel {

  @Inject
  internal lateinit var presenter: ShareBookContract.Presenter
  @Inject
  lateinit var mNavigator: Navigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerShareBookComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .shareBookModule(ShareBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivitySharebookBinding>(this,
        R.layout.activity_sharebook)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    presenter.onStart()
  }

  override fun onStop() {
    presenter.onStop()
    super.onStop()
  }

  fun onClickArrowBack() {
    mNavigator.finishActivity()
  }
}
