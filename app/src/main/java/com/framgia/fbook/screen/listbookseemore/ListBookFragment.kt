package com.framgia.fbook.screen.listbookseemore

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.FragmentListbookBinding
import com.framgia.fbook.screen.BaseFragment
import com.framgia.fbook.screen.EndlessRecyclerOnScrollListener
import com.framgia.fbook.screen.listbookseemore.adapter.ListBookAdapter
import com.framgia.fbook.screen.main.MainActivity
import com.framgia.fbook.screen.onItemRecyclerViewClickListener
import com.framgia.fbook.utils.Constant
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * ListBook Screen.
 */
open class ListBookFragment : BaseFragment(), ListBookContract.ViewModel, onItemRecyclerViewClickListener {

  @Inject
  internal lateinit var mPresenter: ListBookContract.Presenter
  @Inject
  internal lateinit var mDialogManager: DialogManager
  @Inject
  internal lateinit var mListBookAdapter: ListBookAdapter
  val mShowProgress: ObservableField<Boolean> = ObservableField()
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    DaggerListBookComponent.builder()
        .mainComponent((activity as MainActivity).getMainComponent())
        .listBookModule(ListBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.inflate<FragmentListbookBinding>(inflater,
        R.layout.fragment_listbook, container, false)
    binding.viewModel = this
    mListBookAdapter.setItemInternalBookListener(this)
    val typeBook = arguments.getString(Constant.LIST_BOOK_EXTRA)
    mPresenter.getListBook(typeBook, Constant.PAGE)
    val gridLayoutManager = GridLayoutManager(context, 2)
    binding.recyclerListBook.layoutManager = gridLayoutManager
    binding.recyclerListBook.addOnScrollListener(
        object : EndlessRecyclerOnScrollListener(gridLayoutManager) {
          override fun onLoadMore(page: Int) {
            mShowProgress.set(true)
            mPresenter.getListBook(typeBook, page)
          }
        })

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

  override fun onDismissProgressBarDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onShowProgressBarDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onError(exception: BaseException) {
    mDialogManager.dialogError(exception.getMessageError())
    mShowProgress.set(false)
  }

  override fun onGetListBookSuccess(listBook: List<Book>?) {
    mListBookAdapter.updateData(listBook)
    mShowProgress.set(false)
  }

  override fun onItemClickListener(any: Any?) {
    //TODO edit later
  }

  companion object {

    val TAG = ListBookFragment::class.java.simpleName

    fun newInstance(typeBook: String): ListBookFragment {
      val listBookFragment = ListBookFragment()
      val bundle = Bundle()
      bundle.putString(Constant.LIST_BOOK_EXTRA, typeBook)
      listBookFragment.arguments = bundle
      return listBookFragment
    }
  }
}
