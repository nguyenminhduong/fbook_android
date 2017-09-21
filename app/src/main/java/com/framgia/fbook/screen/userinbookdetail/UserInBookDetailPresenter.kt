package com.framgia.fbook.screen.userinbookdetail;

/**
 * Listens to user actions from the UI ({@link UserInBookDetailActivity}), retrieves the data and updates
 * the UI as required.
 */
open class UserInBookDetailPresenter : UserInBookDetailContract.Presenter {

  private var mViewModel: UserInBookDetailContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: UserInBookDetailContract.ViewModel) {
    mViewModel = viewModel
  }
}
