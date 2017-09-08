package com.framgia.fbook.screen.sharebook;

import android.app.Activity
import android.content.Context
import com.framgia.fbook.screen.login.LoginActivity
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import com.framgia.fbook.utils.validator.Validator
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
  fun providePresenter(validator: Validator): ShareBookContract.Presenter {
    val presenter = ShareBookPresenter(validator)
    presenter.setViewModel(activity as ShareBookContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(activity)
  }

  @ActivityScope
  @Provides
  fun provideValidator(context: Context): Validator {
    return Validator(context, LoginActivity::class.java)
  }

  @ActivityScope
  @Provides
  fun provideImageSelectedAdapter(): ImageSelectedAdapter {
    return ImageSelectedAdapter(activity)
  }
}
