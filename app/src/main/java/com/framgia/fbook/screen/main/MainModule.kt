package com.framgia.fbook.screen.main

import android.app.Activity
import com.framia.fbook.screen.main.MainContract
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by daolq on 8/14/17.
 */
@Module
class MainModule(private val mActivity:Activity) {


  @ActivityScope
  @Provides
  fun providePresenter(schedulerProvider : BaseSchedulerProvider): MainContract.Presenter {
    val presenter = MainPresenter()
    presenter.setViewModel(mActivity as MainContract.ViewModel)
    presenter.setSchedulerProvider(schedulerProvider)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mActivity)
  }
}
