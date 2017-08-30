package com.framgia.fbook.screen.SearchBook.internalbook

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentInternalbookBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.SearchBook.SearchBookActivity
import javax.inject.Inject

/**
 * InternalBook Screen.
 */
class InternalBookFragment : BaseFragment() {

  companion object {
    val TAG: String = "InternalBookFragment"

    fun newInstance(): InternalBookFragment {
      return InternalBookFragment()
    }
  }

  @Inject
  internal lateinit var mPresenter: InternalBookContract.Presenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerInternalBookComponent.builder()
        .searchBookComponent((activity as SearchBookActivity).getSearchBookComponent())
        .internalBookModule(InternalBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentInternalbookBinding>(inflater,
        R.layout.fragment_internalbook, container,
        false)
    binding.viewModel = this
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    super.onStop()
    mPresenter.onStop()
  }
}
