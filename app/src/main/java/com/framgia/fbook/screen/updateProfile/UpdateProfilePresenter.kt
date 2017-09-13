package com.framgia.fbook.screen.updateProfile;

/**
 * Listens to user actions from the UI ({@link UpdateProfileActivity}), retrieves the data and updates
 * the UI as required.
 */
class UpdateProfilePresenter : UpdateProfileContract.Presenter {

  private var mViewModel: UpdateProfileContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: UpdateProfileContract.ViewModel) {
    mViewModel = viewModel
  }
}
