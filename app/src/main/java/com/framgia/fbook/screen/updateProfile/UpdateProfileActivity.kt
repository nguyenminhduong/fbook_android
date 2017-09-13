package com.framgia.fbook.screen.updateProfile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.fbook.MainApplication;
import com.framgia.fbook.R;
import com.framgia.fbook.databinding.ActivityUpdateprofileBinding
import com.framgia.fbook.screen.BaseActivity;
import javax.inject.Inject;

/**
 * UpdateProfile Screen.
 */
class UpdateProfileActivity : BaseActivity(), UpdateProfileContract.ViewModel {

  @Inject
  internal lateinit var presenter: UpdateProfileContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerUpdateProfileComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .updateProfileModule(UpdateProfileModule(this))
        .build()
        .inject(this)
    val binding = DataBindingUtil.setContentView<ActivityUpdateprofileBinding>(this,
        R.layout.activity_updateprofile)
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
