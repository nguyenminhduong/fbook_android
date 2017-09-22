package com.framgia.fbook.screen.approverequest;

/**
 * Listens to user actions from the UI ({@link ApproveRequestActivity}), retrieves the data and updates
 * the UI as required.
 */
class ApproveRequestPresenter : ApproveRequestContract.Presenter {

  private var mViewModel: ApproveRequestContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: ApproveRequestContract.ViewModel) {
    mViewModel = viewModel
  }
}
