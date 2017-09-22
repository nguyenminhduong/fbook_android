package com.framgia.fbook.screen.profile;

import io.reactivex.disposables.CompositeDisposable

/**
 * Listens to user actions from the UI ({@link ProfileActivity}), retrieves the data and updates
 * the UI as required.
 */
class ProfilePresenter : ProfileContract.Presenter {

  private var mViewModel: ProfileContract.ViewModel? = null
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }


  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun setViewModel(viewModel: ProfileContract.ViewModel) {
    mViewModel = viewModel
  }
}
