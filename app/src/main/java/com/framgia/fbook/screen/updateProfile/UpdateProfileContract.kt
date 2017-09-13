package com.framgia.fbook.screen.updateProfile;

import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface UpdateProfileContract {
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
