package com.framgia.fbook.screen.approverequest

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivityApproveRequestBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import javax.inject.Inject

/**
 * ApproveRequest Screen.
 */
class ApproveRequestActivity : BaseActivity(), ApproveRequestContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: ApproveRequestContract.Presenter
  @Inject
  lateinit var mNavigator: Navigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerApproveRequestComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .approveRequestModule(ApproveRequestModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityApproveRequestBinding>(this,
        R.layout.activity_approve_request)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  fun onClickArrowBack() {
    mNavigator.finishActivity()
  }
}
