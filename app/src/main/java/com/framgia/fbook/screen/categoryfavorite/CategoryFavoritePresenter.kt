package com.framgia.fbook.screen.categoryfavorite

import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Listens to user actions from the UI ([CategoryFavoriteFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
internal class CategoryFavoritePresenter(
    private val mCategoryRepository: CategoryRepository) : CategoryFavoriteContract.Presenter {


  private var mViewModel: CategoryFavoriteContract.ViewModel? = null
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {}

  override fun onStop() {
    mCompositeDisposable.clear()
  }

  override fun getCategory() {
    val disposable: Disposable = mCategoryRepository.getCategory()
        .subscribeOn(mSchedulerProvider.io())
        .observeOn(mSchedulerProvider.ui())
        .doOnSubscribe { mViewModel?.onShowProgressBar() }
        .doAfterTerminate { mViewModel?.onDismisProgressBar() }
        .subscribe({ listCategoryResponse ->
          mViewModel?.onGetCategorySuccess(listCategoryResponse.items)
        }, { error ->
          mViewModel?.onError(error as BaseException)
        })
    mCompositeDisposable.add(disposable)
  }

  override fun setViewModel(viewModel: CategoryFavoriteContract.ViewModel) {
    mViewModel = viewModel
  }

  fun setSchedulerProvider(schedulerProvider: BaseSchedulerProvider) {
    mSchedulerProvider = schedulerProvider
  }

  companion object {
    private val TAG = CategoryFavoritePresenter::class.java.name
  }
}
