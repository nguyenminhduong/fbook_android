package com.fstyle.fbook

import android.content.Context
import com.fstyle.fbook.data.source.remote.api.NetworkModule
import com.fstyle.fbook.data.source.remote.api.service.NameApi
import com.fstyle.fbook.utils.dagger.AppScope
import com.fstyle.fbook.utils.rx.BaseSchedulerProvider
import dagger.Component

/**
 * Created by le.quang.dao on 21/03/2017.
 */

@AppScope
@Component(
    modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface AppComponent {

  //============== Region for Repository ================//

  fun nameApi(): NameApi

  //=============== Region for common ===============//

  fun applicationContext(): Context

  fun baseSchedulerProvider(): BaseSchedulerProvider
}
