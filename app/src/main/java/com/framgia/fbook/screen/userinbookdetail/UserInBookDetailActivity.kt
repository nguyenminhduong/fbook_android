package com.framgia.fbook.screen.userinbookdetail;

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.databinding.ActivityUserInBookDetailBinding
import com.framgia.fbook.screen.BaseActivity
import javax.inject.Inject

/**
 * UserInBookDetail Screen.
 */
open class UserInBookDetailActivity : BaseActivity(), UserInBookDetailContract.ViewModel {

  @Inject
  internal lateinit var presenter: UserInBookDetailContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerUserInBookDetailComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .userInBookDetailModule(UserInBookDetailModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityUserInBookDetailBinding>(this,
        R.layout.activity_user_in_book_detail)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    presenter.onStart()
  }

  override fun onStop() {
    presenter.onStop()
    super.onStop()
  }
}
