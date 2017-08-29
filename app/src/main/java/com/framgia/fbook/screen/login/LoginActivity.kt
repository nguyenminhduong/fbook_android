package com.framgia.fbook.screen.login;

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivityLoginBinding
import com.framgia.fbook.screen.BaseActivity
import javax.inject.Inject

/**
 * Login Screen.
 */
class LoginActivity : BaseActivity(), LoginContract.ViewModel {

  @Inject
  internal lateinit var presenter: LoginContract.Presenter

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
    presenter.onStart()
  }

  override fun onStop() {
    presenter.onStop()
    super.onStop()
  }

  fun onClickLogin() {
    //Navigation when Click button Login
  }
}
