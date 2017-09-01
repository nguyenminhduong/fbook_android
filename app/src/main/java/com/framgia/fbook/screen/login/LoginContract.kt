package com.framgia.fbook.screen.login;

import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

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

    fun onInvalidEmail(errorMsg: String?)

    fun onInvalidPassWord(errorMsg: String?)

    fun onShowProgressDialog()

    fun onDismissProgressDialog()
  }

  /**
   * Presenter.
   */
  interface Presenter : BasePresenter<ViewModel> {
    fun login(email: String?, password: String?)

    fun checkUserLogin()

    fun validateDataInput(email: String?, password: String?): Boolean

    fun validateEmailInput(email: String?)

    fun validatePasswordInput(password: String?)
  }
}
