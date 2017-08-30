package com.framgia.fbook.screen.mainpage

/**
 * Listens to user actions from the UI ([MainPageFragment]), retrieves the data and updates
 * the UI as required.
 */
internal class MainPagePresenter : MainPageContract.Presenter {

  private lateinit var mViewModel: MainPageContract.ViewModel

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: MainPageContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = MainPagePresenter::class.java.name
  }
}
