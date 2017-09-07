package com.framgia.fbook.screen.mybook

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.FragmentMybookBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.main.MainActivity
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * MyBook Screen.
 */
class MyBookFragment : BaseFragment(), MyBookContract.ViewModel, ItemMyBookClickListener {

  @Inject
  internal lateinit var mPresenter: MyBookContract.Presenter
  @Inject
  internal lateinit var mDialogManager: DialogManager
  @Inject
  internal lateinit var mMyBookAdapter: MyBookAdapter

  private lateinit var mUser: User

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

    mMyBookAdapter.setItemMyBookListener(this)

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

  override fun setUserVisibleHint(isVisibleToUser: Boolean) {
    super.setUserVisibleHint(isVisibleToUser)
    if (!isVisibleToUser) {
      return
    }
    mPresenter.getMyBook(mUser.id!!)
  }

  override fun onError(e: BaseException) {
    Log.e(TAG, e.getMessageError())
  }

  override fun onGetMyBookSuccess(listBook: List<Book>?) {
    listBook?.let { mMyBookAdapter.updateData(it) }
  }

  override fun onGetuserSuccess(user: User?) {
    user?.let { mUser = user }
  }

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onItemMyBookClick(book: Book) {
    //TODO edit later
  }

  companion object {

    val TAG: String = MyBookFragment::class.java.name

    fun newInstance(): MyBookFragment {
      return MyBookFragment()
    }
  }
}
