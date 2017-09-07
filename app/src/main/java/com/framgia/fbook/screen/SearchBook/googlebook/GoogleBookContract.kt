package com.framgia.fbook.screen.SearchBook.googlebook

import com.framgia.fbook.data.model.GoogleBook
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

/**
 * This specifies the contract between the view and the presenter.
 */
interface GoogleBookContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {
    fun onError(error: BaseException)

    fun onSearchBookSuccess(bookList: List<GoogleBook>?)

    fun onShowProgressDialog()

    fun onDismissProgressDialog()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun searchBook(bookName: String?)
  }
}
