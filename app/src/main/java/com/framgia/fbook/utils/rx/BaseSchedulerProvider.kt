package com.framgia.fbook.utils.rx

import io.reactivex.Scheduler

/**
 * Created by le.quang.dao on 28/03/2017.
 */

interface BaseSchedulerProvider {

  fun computation(): Scheduler

  fun io(): Scheduler

  fun ui(): Scheduler
}
