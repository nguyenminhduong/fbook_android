package com.framgia.fbook.screen.mybook

/**
 * Listens to user actions from the UI ([MyBookFragment]), retrieves the data and updates
 * the UI as required.
 */
class MyBookPresenter : MyBookContract.Presenter {

  private var mViewModel: MyBookContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: MyBookContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = MyBookPresenter::class.java.name
  }
}
