package com.framgia.fbook.screen.categoryfavorite

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentCategoryFavoriteBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import javax.inject.Inject

/**
 * CategoryFavorite Screen.
 */
class CategoryFavoriteFragment : BaseFragment() {

  @Inject
  internal lateinit var mPresenter: CategoryFavoriteContract.Presenter

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

  companion object {
    val TAG: String = "CategoryFavoriteFragment"

    fun newInstance(): CategoryFavoriteFragment {
      return CategoryFavoriteFragment()
    }
  }
}
