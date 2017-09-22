package com.framgia.fbook.screen.userinbookdetail.screen.UserReview

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Listens to user actions from the UI ([UserReviewFragment]), retrieves the data and updates
 * the UI as required.
 */
internal class UserReviewPresenter(
    private val mBookRepository: BookRepository) : UserReviewContract.Presenter {

  private var mViewModel: UserReviewContract.ViewModel? = null

  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun setViewModel(viewModel: UserReviewContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }

  companion object {
    private val TAG = UserReviewPresenter::class.java.name
  }
}
