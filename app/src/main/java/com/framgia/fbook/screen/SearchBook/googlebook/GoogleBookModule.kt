package com.framgia.fbook.screen.SearchBook.googlebook

import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [GoogleBookPresenter].
 */
@Module
class GoogleBookModule(fragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(): GoogleBookContract.Presenter {
    return GoogleBookPresenter()
  }
}
