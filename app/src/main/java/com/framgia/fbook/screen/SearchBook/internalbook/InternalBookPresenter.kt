package com.framgia.fbook.screen.SearchBook.internalbook

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([InternalBookFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
class InternalBookPresenter(
    private val mBookRepository: BookRepository) : InternalBookContract.Presenter {

  private var mViewModel: InternalBookContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun searchBook(keyword: String?, field: String?) {
    val disposable: Disposable = mBookRepository.searchBook(keyword, field)
        .subscribeOn(mSchedulerProvider.io())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .observeOn(mSchedulerProvider.ui())
        .subscribe({ listBook -> mViewModel?.onSearchBookSuccess(listBook.items?.data) },
            { error -> mViewModel?.onError(error as BaseException) })
    mCompositeDisposable.add(disposable)
  }

  override fun setViewModel(viewModel: InternalBookContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }

  companion object {
    private val TAG = InternalBookPresenter::class.java.name
  }
}
