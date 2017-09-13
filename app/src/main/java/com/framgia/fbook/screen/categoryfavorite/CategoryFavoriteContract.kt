package com.framgia.fbook.screen.categoryfavorite

import com.framgia.fbook.data.model.Category
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

/**
 * This specifies the contract between the view and the presenter.
 */
internal interface CategoryFavoriteContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {
    fun onGetCategorySuccess(listCategory: List<Category>?)

    fun onError(exception: BaseException)

    fun onShowProgressBar()

    fun onDismisProgressBar()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun getCategory()
  }
}
