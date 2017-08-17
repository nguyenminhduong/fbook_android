package com.framgia.fbook.screen.main

import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import com.framia.fbook.screen.main.MainContract

/**
 * Created by daolq on 8/14/17.
 */
class MainPresenter : MainContract.Presenter {

  private lateinit var mMainViewModel: MainContract.ViewModel
  private lateinit var mSchedulerProvider: BaseSchedulerProvider

  override fun onStart() {
  }

  override fun onStop() {
  }

  override fun setViewModel(viewModel: MainContract.ViewModel) {
    mMainViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }
}
