package com.framgia.fbook.screen.login;

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.source.TokenRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import com.framgia.fbook.databinding.ActivityLoginBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.screen.main.MainActivity
import com.framgia.fbook.utils.navigator.Navigator
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
  @Inject
  internal lateinit var mTokenRepository: TokenRepository
  @Inject
  internal lateinit var mNavigator: Navigator

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
    mPresenter.checkUserLogin()
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  override fun onLoginSuccess(signInResponse: SignInResponse) {
    mTokenRepository.saveToken(signInResponse.signInData?.accessToken.toString())
    onUserLoggedIn()
  }

  override fun onError(exception: BaseException) {
    Log.e(TAG, exception.message)
  }

  override fun onUserLoggedIn() {
    mNavigator.startActivity(MainActivity::class.java)
    mNavigator.finishActivity()
  }

  fun onClickLogin() {
    //TODO edit later
    val signInRequest = SignInRequest()
    signInRequest.email = "tran.dinh.vi@framgia.com"
    signInRequest.password = "12345678"
    mPresenter.login(signInRequest)
  }
}
