package com.framgia.fbook.screen.SearchBook.internalbook

import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [InternalBookPresenter].
 */
@Module
class InternalBookModule(private val mFragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(): InternalBookContract.Presenter {
    return InternalBookPresenter()
  }

}
