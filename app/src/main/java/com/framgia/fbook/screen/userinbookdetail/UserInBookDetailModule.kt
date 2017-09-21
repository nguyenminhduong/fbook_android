package com.framgia.fbook.screen.userinbookdetail;

import android.app.Activity;
import com.framgia.fbook.utils.dagger.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link UserInBookDetailPresenter}.
 */
@Module
class UserInBookDetailModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(): UserInBookDetailContract.Presenter {
    val presenter = UserInBookDetailPresenter()
    presenter.setViewModel(activity as UserInBookDetailContract.ViewModel)
    return presenter
  }
}
