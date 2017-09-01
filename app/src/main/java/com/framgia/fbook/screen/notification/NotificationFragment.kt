package com.framgia.fbook.screen.notification

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.databinding.FragmentNotificationBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import javax.inject.Inject

/**
 * Notification Screen.
 */
class NotificationFragment : BaseFragment(), NotificationContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: NotificationContract.Presenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerNotificationComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .notificationModule(NotificationModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentNotificationBinding>(inflater,
        R.layout.fragment_notification, container,
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

    val TAG: String = NotificationFragment::class.java.name

    fun newInstance(): NotificationFragment {
      return NotificationFragment()
    }
  }
}
