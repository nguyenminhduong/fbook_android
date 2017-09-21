package com.framgia.fbook.screen.addCategoryFavorite;

import com.framgia.fbook.data.model.Category
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface AddCategoryFavoriteContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {

    fun onShowProgressDialog()

    fun onDismissProgressDialog()

    fun onError(exception: BaseException)

    fun onGetCategorySuccess(category: List<Category>?)

    fun onUpdateCategoryFavoriteSuccess()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {

    fun getCategory()

    fun updateCategory(tag: String?)
  }
}
