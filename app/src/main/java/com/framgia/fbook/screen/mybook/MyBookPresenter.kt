package com.framgia.fbook.screen.mybook

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([MyBookFragment]), retrieves the data and updates
 * the UI as required.
 */
class MyBookPresenter constructor(
    private val mBookRepository: BookRepository,
    private val mBaseSchedulerProvider: BaseSchedulerProvider,
    private val mUserRepository: UserRepository) : MyBookContract.Presenter {

  private var mViewModel: MyBookContract.ViewModel? = null
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun getMyBook(userId: Int) {
    val disposable: Disposable = mBookRepository.getMyBook(userId)
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { listBook ->
              mViewModel?.onGetMyBookSuccess(listBook.items?.data)
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }

  override fun getUser() {
    val disposable: Disposable = mUserRepository.getUserLocal()
        .subscribeOn(mBaseSchedulerProvider.io())
        .observeOn(mBaseSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressDialog() }
        .doAfterTerminate { mViewModel?.onDismissProgressDialog() }
        .subscribe(
            { user ->
              mViewModel?.onGetuserSuccess(user)
            },
            { error ->
              mViewModel?.onError(error as BaseException)
            })
    mCompositeDisposable.add(disposable)
  }

  override fun setViewModel(viewModel: MyBookContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = MyBookPresenter::class.java.name
  }
}
