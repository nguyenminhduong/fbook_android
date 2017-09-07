package com.framgia.fbook.screen.main

import android.content.Context
import com.framgia.fbook.AppComponent
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsApi
import com.framgia.fbook.data.source.remote.api.service.FBookApi
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Component

/**
 * Created by daolq on 8/14/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
  fun inject(mainActivity: MainActivity)

  //============== Region for Repository ================//

  fun fbookApi(): FBookApi

  fun sharedPrefsApi(): SharedPrefsApi

  //=============== Region for common ===============//

  fun applicationContext(): Context

  fun baseSchedulerProvider(): BaseSchedulerProvider
}
