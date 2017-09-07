package com.framgia.fbook.screen.menuprofile

import io.reactivex.disposables.CompositeDisposable

/**
 * Listens to user actions from the UI ([MenuProfileFragment]), retrieves the data and updates
 * the UI as required.
 */
class MenuProfilePresenter : MenuProfileContract.Presenter {

  private var mViewModel: MenuProfileContract.ViewModel? = null
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun setViewModel(viewModel: MenuProfileContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = MenuProfilePresenter::class.java.name
  }
}
