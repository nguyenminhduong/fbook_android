package com.framgia.fbook.screen.listbookseemore

import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([ListBookFragment]), retrieves the data and updates
 * the UI as required.
 */
open class ListBookPresenter(
    private val mBookRepository: BookRepository) : ListBookContract.Presenter {

  private var mViewModel: ListBookContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun getListBook(typeBook: String?, page: Int?) {
    typeBook?.let {
      when (typeBook) {
        Constant.LATE -> {
          val disposable: Disposable = mBookRepository.getSectionListBook(Constant.LATE, page)
              .subscribeOn(mSchedulerProvider.io())
              .observeOn(mSchedulerProvider.ui())
              .subscribe({ listBookLateResponse ->
                mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
              }, { error ->
                mViewModel?.onError(error as BaseException)
              })
          mCompositeDisposable.add(disposable)
        }
        Constant.VIEW -> {
          val disposable: Disposable = mBookRepository.getSectionListBook(Constant.VIEW, page)
              .subscribeOn(mSchedulerProvider.io())
              .observeOn(mSchedulerProvider.ui())
              .subscribe({ listBookLateResponse ->
                mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
              }, { error ->
                mViewModel?.onError(error as BaseException)
              })
          mCompositeDisposable.add(disposable)
        }
        Constant.RATING -> {
          val disposable: Disposable = mBookRepository.getSectionListBook(Constant.RATING,
              page)
              .subscribeOn(mSchedulerProvider.io())
              .observeOn(mSchedulerProvider.ui())
              .subscribe({ listBookLateResponse ->
                mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
              }, { error ->
                mViewModel?.onError(error as BaseException)
              })
          mCompositeDisposable.add(disposable)
        }
        Constant.WAITING -> {
          val disposable: Disposable = mBookRepository.getSectionListBook(Constant.WAITING,
              page)
              .subscribeOn(mSchedulerProvider.io())
              .observeOn(mSchedulerProvider.ui())
              .subscribe({ listBookLateResponse ->
                mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
              }, { error ->
                mViewModel?.onError(error as BaseException)
              })
          mCompositeDisposable.add(disposable)
        }
        Constant.READ -> {
          val disposable: Disposable = mBookRepository.getSectionListBook(Constant.READ, page)
              .subscribeOn(mSchedulerProvider.io())
              .observeOn(mSchedulerProvider.ui())
              .subscribe({ listBookLateResponse ->
                mViewModel?.onGetListBookSuccess(listBookLateResponse.item?.data)
              }, { error ->
                mViewModel?.onError(error as BaseException)
              })
          mCompositeDisposable.add(disposable)
        }
        else -> {}
      }
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
