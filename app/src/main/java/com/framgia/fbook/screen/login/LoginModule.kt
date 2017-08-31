package com.framgia.fbook.screen.login;

import android.app.Activity
import com.framgia.fbook.data.source.TokenRepository
import com.framgia.fbook.data.source.TokenRepositoryImpl
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.TokenLocalDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link LoginPresenter}.
 */
@Module
class LoginModule(private val mActivity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(schedulerProvider: BaseSchedulerProvider,
      userRepository: UserRepository, tokenRepository: TokenRepository): LoginContract.Presenter {
    val presenter = LoginPresenter(userRepository, tokenRepository)
    presenter.setViewModel(mActivity as LoginContract.ViewModel)
    presenter.setSchedulerProvider(schedulerProvider)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource)
  }

  @ActivityScope
  @Provides
  fun provideTokenRepository(tokenLocalDataSource: TokenLocalDataSource): TokenRepository {
    return TokenRepositoryImpl(tokenLocalDataSource)
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mActivity)
  }
}
