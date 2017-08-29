package com.framgia.fbook.screen.SearchBook.googlebook

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentGooglebookBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.SearchBook.SearchBookActivity
import javax.inject.Inject

/**
 * GoogleBook Screen.
 */
class GoogleBookFragment : BaseFragment() {

  @Inject
  internal lateinit var mPresenter: GoogleBookContract.Presenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerGoogleBookComponent.builder()
        .searchBookComponent((activity as SearchBookActivity).getSearchBookComponent())
        .googleBookModule(GoogleBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentGooglebookBinding>(inflater,
        R.layout.fragment_googlebook, container, false)
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

    val TAG: String = "GoogleBookFragment"

    fun newInstance(): GoogleBookFragment {
      return GoogleBookFragment()
    }
  }
}
