package com.framgia.fbook.screen.sharebook;

import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ShareBookContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {

    fun onInputTitleError(errorMsg: String?)

    fun onInputAuthorError(errorMsg: String?)

    fun onInputDescriptionError(errorMsg: String?)
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun validateDataInput(bookRequest: BookRequest): Boolean
  }
}
