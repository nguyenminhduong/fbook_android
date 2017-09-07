package com.framgia.fbook

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.framgia.fbook.data.source.remote.api.NetworkModule
import io.fabric.sdk.android.Fabric

/**
 * Created by le.quang.dao on 10/03/2017.
 */

class MainApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder()
        .applicationModule(ApplicationModule(applicationContext))
        .networkModule(NetworkModule(this))
        .build()
    Fabric.with(this, Crashlytics())
  }
}
