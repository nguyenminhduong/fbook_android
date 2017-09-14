package com.framgia.fbook.screen.listbookseemore

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.screen.mainpage.TypeBook
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([ListBookFragment]), retrieves the data and updates
 * the UI as required.
 */
open class ListBookPresenter(private val mBookRepository: BookRepository) : ListBookContract.Presenter {

  private var mViewModel: ListBookContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun getListBook(typeBook: Int?) {
    if (typeBook == TypeBook.LATE_BOOK) {
      val disposable: Disposable = mBookRepository.getSectionListBook(Constant.LATE, Constant.PAGE)
          .subscribeOn(mSchedulerProvider.io())
          .observeOn(mSchedulerProvider.ui())
          .subscribe({ listBookLateResponse ->
            mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
          }, { error ->
            mViewModel?.onError(error as BaseException)
          })
      mCompositeDisposable.addAll(disposable)
    }
    if (typeBook == TypeBook.VIEW_BOOK) {
      val disposable: Disposable = mBookRepository.getSectionListBook(Constant.VIEW, Constant.PAGE)
          .subscribeOn(mSchedulerProvider.io())
          .observeOn(mSchedulerProvider.ui())
          .subscribe({ listBookLateResponse ->
            mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
          }, { error ->
            mViewModel?.onError(error as BaseException)
          })
      mCompositeDisposable.addAll(disposable)
    }
    if (typeBook == TypeBook.RATING_BOOK) {
      val disposable: Disposable = mBookRepository.getSectionListBook(Constant.RATING,
          Constant.PAGE)
          .subscribeOn(mSchedulerProvider.io())
          .observeOn(mSchedulerProvider.ui())
          .subscribe({ listBookLateResponse ->
            mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
          }, { error ->
            mViewModel?.onError(error as BaseException)
          })
      mCompositeDisposable.addAll(disposable)
    }
    if (typeBook == TypeBook.WAITING_BOOK) {
      val disposable: Disposable = mBookRepository.getSectionListBook(Constant.WAITING,
          Constant.PAGE)
          .subscribeOn(mSchedulerProvider.io())
          .observeOn(mSchedulerProvider.ui())
          .subscribe({ listBookLateResponse ->
            mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
          }, { error ->
            mViewModel?.onError(error as BaseException)
          })
      mCompositeDisposable.addAll(disposable)
    }
    if (typeBook == TypeBook.READ_BOOK) {
      val disposable: Disposable = mBookRepository.getSectionListBook(Constant.READ, Constant.PAGE)
          .subscribeOn(mSchedulerProvider.io())
          .observeOn(mSchedulerProvider.ui())
          .subscribe({ listBookLateResponse ->
            mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
          }, { error ->
            mViewModel?.onError(error as BaseException)
          })
      mCompositeDisposable.addAll(disposable)
    }

  }

  override fun setViewModel(viewModel: ListBookContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }

  companion object {
    private val TAG = ListBookPresenter::class.java.name
  }
}
