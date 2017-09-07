package com.framgia.fbook.screen.categoryfavorite

import android.app.Activity
import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [CategoryFavoritePresenter].
 */
@Module
class CategoryFavoriteModule(fragment: Fragment) {

  @FragmentScope
  @Provides
  internal fun providePresenter(): CategoryFavoriteContract.Presenter {
    return CategoryFavoritePresenter()
  }
}
