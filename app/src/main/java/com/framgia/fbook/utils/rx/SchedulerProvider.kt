package com.fstyle.fbook.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by le.quang.dao on 28/03/2017.
 */

class SchedulerProvider private constructor() : BaseSchedulerProvider {

  override fun computation(): Scheduler {
    return Schedulers.computation()
  }

  override fun io(): Scheduler {
    return Schedulers.io()
  }

  override fun ui(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

  private object SchedulerProvider {
    val instance = SchedulerProvider()
  }

  companion object {
    val instance: com.fstyle.fbook.utils.rx.SchedulerProvider by lazy { SchedulerProvider.instance }
  }
}
