package com.framgia.fbook.screen.listbookseemore

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

/**
 * This specifies the contract between the view and the presenter.
 */
interface ListBookContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {
    fun onError(exception: BaseException)

    fun onGetListBookSuccess(listBook: List<Book>?)

    fun onShowProgressBarDialog()

    fun onDismissProgressBarDialog()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun getListBook(typeBook: String?, page: Int?)
  }
}
