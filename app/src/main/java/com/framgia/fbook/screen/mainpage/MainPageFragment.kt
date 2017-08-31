package com.framgia.fbook.screen.mainpage

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentMainPageBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import javax.inject.Inject

/**
 * MainPage Screen.
 */
class MainPageFragment : BaseFragment() {

  @Inject
  internal lateinit var mPresenter: MainPageContract.Presenter

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    DaggerMainPageComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .mainPageModule(MainPageModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater,
        R.layout.fragment_main_page, container, false)
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

    fun newInstance(): MainPageFragment {
      return MainPageFragment()
    }
  }
}
