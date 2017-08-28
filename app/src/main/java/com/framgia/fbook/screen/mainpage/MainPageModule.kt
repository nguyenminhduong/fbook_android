package com.framgia.fbook.screen.mainpage

import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [MainPagePresenter].
 */
@Module
class MainPageModule(private val mFragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(): MainPageContract.Presenter {
    return MainPagePresenter()
  }
}
