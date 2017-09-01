package com.framgia.fbook.screen.mybook

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentMybookBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import javax.inject.Inject

/**
 * MyBook Screen.
 */
class MyBookFragment : BaseFragment(), MyBookContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: MyBookContract.Presenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerMyBookComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .myBookModule(MyBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentMybookBinding>(inflater, R.layout.fragment_mybook,
        container, false)
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

    val TAG: String = MyBookFragment::class.java.name

    fun newInstance(): MyBookFragment {
      return MyBookFragment()
    }
  }
}
