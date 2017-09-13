package com.framgia.fbook.screen.updateProfile;

import android.app.Activity
import com.framgia.fbook.utils.dagger.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link UpdateProfilePresenter}.
 */
@Module
class UpdateProfileModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(): UpdateProfileContract.Presenter {
    val presenter = UpdateProfilePresenter()
    presenter.setViewModel(activity as UpdateProfileContract.ViewModel)
    return presenter
  }
}
