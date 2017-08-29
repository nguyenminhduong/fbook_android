package com.framgia.fbook.screen.SearchBook;

/**
 * Listens to user actions from the UI ({@link SearchBookActivity}), retrieves the data and updates
 * the UI as required.
 */
class SearchBookPresenter : SearchBookContract.Presenter {

  private lateinit var mViewModel: SearchBookContract.ViewModel

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: SearchBookContract.ViewModel) {
    mViewModel = viewModel
  }
}
