package com.framgia.fbook.screen.notification

import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [NotificationPresenter].
 */
@Module
class NotificationModule(fragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(): NotificationContract.Presenter {
    return NotificationPresenter()
  }
}
