package com.framgia.fbook.screen.sharebook;

import android.app.Activity
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link ShareBookPresenter}.
 */
@Module
class ShareBookModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(): ShareBookContract.Presenter {
    val presenter = ShareBookPresenter()
    presenter.setViewModel(activity as ShareBookContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(activity)
  }

}
