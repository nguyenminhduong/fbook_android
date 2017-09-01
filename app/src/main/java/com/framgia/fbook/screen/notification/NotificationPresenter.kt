package com.framgia.fbook.screen.notification

/**
 * Listens to user actions from the UI ([NotificationFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
class NotificationPresenter : NotificationContract.Presenter {

  private var mViewModel: NotificationContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: NotificationContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = NotificationPresenter::class.java.name
  }
}
