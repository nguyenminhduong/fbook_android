package com.framgia.fbook.screen.mybook

import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [MyBookPresenter].
 */
@Module
class MyBookModule(fragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(): MyBookContract.Presenter {
    return MyBookPresenter()
  }
}
