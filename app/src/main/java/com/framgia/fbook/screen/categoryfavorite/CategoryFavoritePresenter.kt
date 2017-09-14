package com.framgia.fbook.screen.categoryfavorite

/**
 * Listens to user actions from the UI ([CategoryFavoriteFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
internal class CategoryFavoritePresenter : CategoryFavoriteContract.Presenter {


  private var mViewModel: CategoryFavoriteContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {
  }

  override fun setViewModel(viewModel: CategoryFavoriteContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = CategoryFavoritePresenter::class.java.name
  }
}
