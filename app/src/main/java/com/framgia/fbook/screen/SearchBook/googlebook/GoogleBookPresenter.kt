package com.framgia.fbook.screen.SearchBook.googlebook

/**
 * Listens to user actions from the UI ([GoogleBookFragment]), retrieves the data and updates
 * the UI as required.
 */
class GoogleBookPresenter : GoogleBookContract.Presenter {

  private var mViewModel: GoogleBookContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: GoogleBookContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = GoogleBookPresenter::class.java.name
  }
}
