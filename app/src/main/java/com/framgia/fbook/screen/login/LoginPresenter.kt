package com.framgia.fbook.screen.login;

import com.framgia.fbook.utils.rx.BaseSchedulerProvider

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
class LoginPresenter : LoginContract.Presenter {

  private var mViewModel: LoginContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: LoginContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }
}
