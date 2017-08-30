package com.framgia.fbook.screen.login;

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.util.Log
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import com.framgia.fbook.databinding.ActivityLoginBinding
import com.framgia.fbook.screen.BaseActivity
import javax.inject.Inject

/**
 * Login Screen.
 */
class LoginActivity : BaseActivity(), LoginContract.ViewModel {

  companion object {
    val TAG: String = LoginActivity::class.java.name
  }

  @Inject
  internal lateinit var mPresenter: LoginContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerLoginComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .loginModule(LoginModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,
        R.layout.activity_login)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  //TODO edit later
  override fun onLoginSuccess(signInResponse: SignInResponse) {
    Log.e(TAG, signInResponse.signInData?.accessToken.toString())
  }

  override fun onError(exception: BaseException) {
    Log.e(TAG, exception.message)
  }

  fun onClickLogin() {
    //TODO edit later
    val signInRequest: SignInRequest = SignInRequest()
    signInRequest.email = "nguyen.van.a@framgia.com"
    signInRequest.password = "12345678"
    mPresenter.login(signInRequest)
  }
}
