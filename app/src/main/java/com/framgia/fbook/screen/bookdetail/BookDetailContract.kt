package com.framgia.fbook.screen.bookdetail;

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface BookDetailContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {

    fun onError(e: BaseException)

    fun onGetBookDetailSuccess(book: Book?)
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {

    fun getBookDetail(bookId: Int?)
  }
}
