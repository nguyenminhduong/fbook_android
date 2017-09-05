package com.framgia.fbook.screen.personalinfor

import android.app.Activity
import android.support.v4.app.Fragment
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [PersonalInforPresenter].
 */
@Module
class PersonalInforModule(fragment: Fragment) {

  private val mActivity: Activity

  init {
    this.mActivity = fragment.activity
  }

  @FragmentScope
  @Provides
  internal fun providePresenter(): PersonalInforContract.Presenter {
    return PersonalInforPresenter()
  }
}
