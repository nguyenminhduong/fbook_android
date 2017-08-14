package com.framgia.fbook

import android.content.Context
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsApi
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsImpl
import com.framgia.fbook.utils.dagger.AppScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import com.framgia.fbook.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by le.quang.dao on 21/03/2017.
 */

@Module
class ApplicationModule(private val mContext: Context) {

  @Provides
  @AppScope
  fun provideApplicationContext(): Context {
    return mContext
  }

  @Provides
  @AppScope
  fun provideSharedPrefsApi(): SharedPrefsApi {
    return SharedPrefsImpl(mContext)
  }

  @Provides
  @AppScope
  fun provideBaseSchedulerProvider(): BaseSchedulerProvider {
    return SchedulerProvider.instance
  }
}
