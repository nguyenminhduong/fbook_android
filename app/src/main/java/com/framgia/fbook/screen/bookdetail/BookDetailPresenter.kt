package com.framgia.fbook.screen.bookdetail;

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Listens to user actions from the UI ({@link BookDetailActivity}), retrieves the data and updates
 * the UI as required.
 */
class BookDetailPresenter(
    private val mBookRepository: BookRepository) : BookDetailContract.Presenter {

  private var mViewModel: BookDetailContract.ViewModel? = null
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
  private lateinit var mBaseSchedulerProvider: BaseSchedulerProvider

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun setViewModel(viewModel: BookDetailContract.ViewModel) {
    mViewModel = viewModel
  }

  override fun getBookDetail(bookId: Int?) {
    //TODO get Book Detail
  }

  fun setSchedulerProvider(baseSchedulerProvider: BaseSchedulerProvider) {
    mBaseSchedulerProvider = baseSchedulerProvider
  }
}
