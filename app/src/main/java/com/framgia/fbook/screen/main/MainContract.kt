package com.framia.fbook.screen.main

import com.framgia.fbook.screen.BasePresenter
import com.framgia.fbook.screen.BaseViewModel

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface MainContract {

  /**
   * ViewModel
   */
  interface ViewModel : BaseViewModel

  /**
   * Presenter
   */
  interface Presenter : BasePresenter<ViewModel>
}
