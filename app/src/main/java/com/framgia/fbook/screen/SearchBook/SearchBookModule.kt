package com.framgia.fbook.screen.SearchBook;

import android.app.Activity
import android.support.v4.app.FragmentActivity
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link SearchBookPresenter}.
 */
@Module
class SearchBookModule(private val mActivity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(): SearchBookContract.Presenter {
    val presenter = SearchBookPresenter()
    presenter.setViewModel(mActivity as SearchBookContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mActivity)
  }

  @ActivityScope
  @Provides
  fun providePageAdapter(): SearchBookPagerAdapter {
    return SearchBookPagerAdapter(mActivity, (mActivity as FragmentActivity).supportFragmentManager)
  }
}
