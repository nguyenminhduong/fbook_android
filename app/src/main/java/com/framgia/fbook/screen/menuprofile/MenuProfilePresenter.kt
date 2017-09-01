package com.framgia.fbook.screen.menuprofile

/**
 * Listens to user actions from the UI ([MenuProfileFragment]), retrieves the data and updates
 * the UI as required.
 */
 class MenuProfilePresenter : MenuProfileContract.Presenter {

  private var mViewModel: MenuProfileContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: MenuProfileContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = MenuProfilePresenter::class.java.name
  }
}
