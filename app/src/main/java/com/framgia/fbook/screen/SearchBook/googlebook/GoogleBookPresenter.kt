package com.framgia.fbook.screen.SearchBook.googlebook

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([GoogleBookFragment]), retrieves the data and updates
 * the UI as required.
 */
open class GoogleBookPresenter(
    private val mBookRepository: BookRepository) : GoogleBookContract.Presenter {

  private var mViewModel: GoogleBookContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun searchBook(bookName: String?) {
    val disposable: Disposable = mBookRepository.searchBookWithGoogleApi(bookName)
        .subscribeOn(mSchedulerProvider.io())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .observeOn(mSchedulerProvider.ui())
        .subscribe(
            { bookResponse -> mViewModel?.onSearchBookSuccess(bookResponse.items) },
            { error -> mViewModel?.onError(error as BaseException) }
        )
    mCompositeDisposable.add(disposable)
  }

  override fun setViewModel(viewModel: GoogleBookContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(baseSchedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = baseSchedulerProvider
  }

  companion object {
    private val TAG = GoogleBookPresenter::class.java.name
  }
}
