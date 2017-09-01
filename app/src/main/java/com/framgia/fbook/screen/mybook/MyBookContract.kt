package com.framgia.fbook.screen.mybook

import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

/**
 * This specifies the contract between the view and the presenter.
 */
interface MyBookContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel>
}
