package com.fstyle.fbook

import android.app.Application
import com.fstyle.fbook.data.source.remote.api.NetworkModule

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
  }
}
