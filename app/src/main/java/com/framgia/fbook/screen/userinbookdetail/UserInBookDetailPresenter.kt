package com.framgia.fbook.screen.userinbookdetail;

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Listens to user actions from the UI ({@link UserInBookDetailActivity}), retrieves the data and updates
 * the UI as required.
 */
open class UserInBookDetailPresenter(
    private val mBookRepository: BookRepository) : UserInBookDetailContract.Presenter {

  private var mViewModel: UserInBookDetailContract.ViewModel? = null

  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
  private lateinit var mBaseSchedulerProvider: BaseSchedulerProvider

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: UserInBookDetailContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(baseSchedulerProvider: BaseSchedulerProvider) {
    mBaseSchedulerProvider = baseSchedulerProvider
  }
}
