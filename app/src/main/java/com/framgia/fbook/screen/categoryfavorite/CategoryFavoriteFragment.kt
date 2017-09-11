package com.framgia.fbook.screen.categoryfavorite

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Category
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.FragmentCategoryFavoriteBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import javax.inject.Inject

/**
 * CategoryFavorite Screen.
 */
class CategoryFavoriteFragment : BaseFragment(), CategoryFavoriteContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: CategoryFavoriteContract.Presenter
  @Inject
  internal lateinit var mAdapter: CategoryAdapter
  val mIsVisiableProgressBarListCategory: ObservableField<Boolean> = ObservableField(false)

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerCategoryFavoriteComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .categoryFavoriteModule(CategoryFavoriteModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentCategoryFavoriteBinding>(inflater,
        R.layout.fragment_category_favorite, container,
        false)
    binding.viewModel = this
    mPresenter.getCategory()
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  override fun onGetCategorySuccess(listCategory: List<Category>?) {
    mAdapter.updateData(listCategory)
  }

  override fun onShowProgressBar() {
    mIsVisiableProgressBarListCategory.set(true)
  }

  override fun onDismisProgressBar() {
    mIsVisiableProgressBarListCategory.set(false)
  }

  override fun onError(exception: BaseException) {
    Log.e(TAG, exception.getMessageError())
  }

  companion object {
    val TAG: String = CategoryFavoriteFragment::class.java.name

    fun newInstance(): CategoryFavoriteFragment {
      return CategoryFavoriteFragment()
    }
  }
}
