package com.framgia.fbook.screen.approverequest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.ActivityApproveRequestBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.screen.mybook.MyBookFragment
import com.framgia.fbook.utils.navigator.Navigator
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * ApproveRequest Screen.
 */
class ApproveRequestActivity : BaseActivity(), ApproveRequestContract.ViewModel {
  @Inject
  internal lateinit var mPresenter: ApproveRequestContract.Presenter
  @Inject
  internal lateinit var mDialogManager: DialogManager
  @Inject
  internal lateinit var mApproveRequestAdapter: ApproveRequestAdapter
  @Inject
  internal lateinit var mNavigator: Navigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerApproveRequestComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .approveRequestModule(ApproveRequestModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityApproveRequestBinding>(this,
        R.layout.activity_approve_request)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  override fun onGetApproveRequestSuccess(listBook: List<Book>?) {
  }

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onError(e: BaseException) {
    Log.e(MyBookFragment.TAG, e.getMessageError())

  }

  fun onClickArrowBack() {
    mNavigator.finishActivity()
  }
}
