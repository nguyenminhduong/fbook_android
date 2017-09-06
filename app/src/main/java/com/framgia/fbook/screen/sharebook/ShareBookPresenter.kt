package com.framgia.fbook.screen.sharebook;

/**
 * Listens to user actions from the UI ({@link ShareBookActivity}), retrieves the data and updates
 * the UI as required.
 */
class ShareBookPresenter : ShareBookContract.Presenter {

  private var mViewModel: ShareBookContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: ShareBookContract.ViewModel) {
    mViewModel = viewModel
  }
}
