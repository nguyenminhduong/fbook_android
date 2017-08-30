package com.framgia.fbook.screen.login;

import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
class LoginPresenter(private val mUserRepository: UserRepository) : LoginContract.Presenter {

  private var mViewModel: LoginContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun setViewModel(viewModel: LoginContract.ViewModel) {
    mViewModel = viewModel
  }

  override fun login(signInRequest: SignInRequest) {
    val disposable: Disposable = mUserRepository.login(signInRequest)
        .subscribeOn(mSchedulerProvider.io())
        .observeOn(mSchedulerProvider.ui())
        .subscribe({ signInResponse -> mViewModel?.onLoginSuccess(signInResponse) },
            { e -> mViewModel?.onError(e as BaseException) })
    mCompositeDisposable.add(disposable)
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }
}
