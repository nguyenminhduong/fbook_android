package com.fstyle.fbook

import android.content.Context
import com.fstyle.fbook.data.source.local.sharedprf.SharedPrefsApi
import com.fstyle.fbook.data.source.local.sharedprf.SharedPrefsImpl
import com.fstyle.fbook.utils.dagger.AppScope
import com.fstyle.fbook.utils.rx.BaseSchedulerProvider
import com.fstyle.fbook.utils.rx.SchedulerProvider
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
