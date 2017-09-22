package com.framgia.fbook.screen.userinbookdetail;

import com.framgia.fbook.AppComponent
import com.framgia.fbook.data.source.remote.api.service.FBookApi
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Component

/**
 * This is a Dagger component. Refer to {@link com.framgia.fbook.MainApplication} for the list of Dagger components
 * used in this application.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(UserInBookDetailModule::class))
interface UserInBookDetailComponent {
  fun inject(userInBookDetailActivity: UserInBookDetailActivity)

  fun fBookApi(): FBookApi

  fun baseSchedulerProvider(): BaseSchedulerProvider
}
