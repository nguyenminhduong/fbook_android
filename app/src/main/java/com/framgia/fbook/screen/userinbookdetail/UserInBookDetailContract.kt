package com.framgia.fbook.screen.userinbookdetail;

import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface UserInBookDetailContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
  }
}
