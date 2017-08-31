package com.framgia.fbook.screen.login;

import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import com.framgia.fbook.screen.BasePresenter;
import com.framgia.fbook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface LoginContract {
  /**
   * View.
   */
  interface ViewModel : BaseViewModel {
    fun onLoginSuccess(signInResponse: SignInResponse)

    fun onError(exception: BaseException)

    fun onUserLoggedIn()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun login(signInRequest: SignInRequest)

    fun checkUserLogin()
  }
}
