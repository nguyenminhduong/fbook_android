package com.framgia.fbook.screen.SearchBook.internalbook

/**
 * Listens to user actions from the UI ([InternalBookFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
 class InternalBookPresenter : InternalBookContract.Presenter {

  private var mViewModel: InternalBookContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: InternalBookContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = InternalBookPresenter::class.java.name
  }
}
