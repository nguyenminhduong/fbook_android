package com.framgia.fbook.screen.login;

import android.app.Activity
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link LoginPresenter}.
 */
@Module
class LoginModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(schedulerProvider: BaseSchedulerProvider): LoginContract.Presenter {
    val presenter = LoginPresenter()
    presenter.setViewModel(activity as LoginContract.ViewModel)
    presenter.setSchedulerProvider(schedulerProvider)
    return presenter
  }
}
