package com.framgia.fbook.screen.sharebook;

import com.framgia.fbook.data.model.Office
import com.framgia.fbook.data.source.remote.api.error.BaseException
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

    fun onGetOfficeSuccess(listOffice: List<Office>?)

    fun onError(baseException: BaseException)

    fun onShowProgressDialog()

    fun onDismissProgressDialog()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun validateDataInput(bookRequest: BookRequest): Boolean

    fun getData()
  }
}
