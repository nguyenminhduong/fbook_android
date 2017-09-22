package com.framgia.fbook.screen.approverequest

import android.app.Activity
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link ApproveRequestPresenter}.
 */
@Module
class ApproveRequestModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(): ApproveRequestContract.Presenter {
    val presenter = ApproveRequestPresenter()
    presenter.setViewModel(activity as ApproveRequestContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(activity)
  }
}
