package com.framgia.fbook.screen.main

import com.framia.fbook.screen.main.MainContract
import com.framgia.fbook.utils.rx.BaseSchedulerProvider

/**
 * Created by daolq on 8/14/17.
 */
class MainPresenter : MainContract.Presenter{

  private lateinit var mMainViewModel: MainContract.ViewModel
  private lateinit var mSchedulerProvider : BaseSchedulerProvider

  override fun onStart() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onStop() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setViewModel(viewModel: MainContract.ViewModel) {
    mMainViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider){
    mSchedulerProvider = schedulerProvider
  }
}
