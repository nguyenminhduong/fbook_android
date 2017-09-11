package com.framgia.fbook.screen.personalinfor

import android.app.Activity
import android.support.v4.app.Fragment
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [PersonalInforPresenter].
 */
@Module
class PersonalInforModule(fragment: Fragment) {

  private val mActivity: Activity

  init {
    this.mActivity = fragment.activity
  }

  @FragmentScope
  @Provides
  internal fun providePresenter(): PersonalInforContract.Presenter {
    return PersonalInforPresenter()
  }

  @FragmentScope
  @Provides
  fun providerUserRepository(userRemoteDataSource: UserRemoteDataSource,
      userLocalDataSource: UserLocalDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource, userLocalDataSource)
  }
}
