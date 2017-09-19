package com.framgia.fbook.screen.bookdetail;

import com.framgia.fbook.data.model.ReadingBook
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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
    val disposable: Disposable = mBookRepository.getBookDetail(bookId)
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { book ->
              mViewModel?.onGetBookDetailSuccess(book.item)
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }

  override fun addUserHaveThisBook(bookId: Int?) {
    val disposable: Disposable = mBookRepository.addUserHaveThisBook(bookId)
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { book ->
              mViewModel?.onAddUserHaveThisBookSuccess()
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }

  override fun removeOwnerThisBook(bookId: Int?) {
    val disposable: Disposable = mBookRepository.removeOwnerThisBook(bookId)
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { book ->
              mViewModel?.onRemoveOwnerThisBookSuccess()
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }

  override fun wantToReadingBook(readingBook: ReadingBook?) {
    val disposable: Disposable = mBookRepository.wantToReadingBook(readingBook)
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { book ->
              mViewModel?.onWantToReadingBookSuccess()
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }


  fun setSchedulerProvider(baseSchedulerProvider: BaseSchedulerProvider) {
    mBaseSchedulerProvider = baseSchedulerProvider
  }
}
