package com.framgia.fbook.screen.bookdetail;

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.util.Log
import android.view.View
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.Owner
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.ActivityBookdetailBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.screen.SearchBook.SearchBookActivity
import com.framgia.fbook.screen.login.LoginActivity
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.navigator.Navigator
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * BookDetail Screen.
 */
class BookDetailActivity : BaseActivity(), BookDetailContract.ViewModel, ItemOwnerClickListener {

  companion object {
    val TAG: String = LoginActivity::class.java.name
  }

  @Inject
  internal lateinit var presenter: BookDetailContract.Presenter
  @Inject
  internal lateinit var mNavigator: Navigator
  @Inject
  internal lateinit var mDialogManager: DialogManager
  @Inject
  internal lateinit var mOwnerAdapter: OwnerAdapter

  val mBook: ObservableField<Book> = ObservableField()
  val mCoverBook: ObservableField<String> = ObservableField()
  val mNumberOfReViewDetail: ObservableField<Int> = ObservableField()
  val mNumberOfWaiting: ObservableField<Int> = ObservableField()
  val mNumberOfReading: ObservableField<Int> = ObservableField()
  val mNumberOfReturning: ObservableField<Int> = ObservableField()
  val mNumberOfReturned: ObservableField<Int> = ObservableField()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerBookDetailComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .bookDetailModule(BookDetailModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityBookdetailBinding>(this,
        R.layout.activity_bookdetail)
    initData()
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

  override fun onGetBookDetailSuccess(book: Book?) {
    book?.let {
      mBook.set(it)
      mNumberOfReViewDetail.set(it.reviewDetails?.size)
      mNumberOfWaiting.set(it.usersWaitings?.size)
      mNumberOfReading.set(it.usersReadings?.size)
      mNumberOfReturning.set(it.usersReturnings?.size)
      mNumberOfReturned.set(it.usersReturneds?.size)
      mOwnerAdapter.updateData(it.owners)
      mCoverBook.set(it.images?.get(0)?.mobileImage?.smallPath)
    }
  }

  override fun onError(e: BaseException) {
    Log.e(TAG, e.getMessageError())
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onItemOwnerClick(owner: Owner?) {
    //TODO edit later
  }

  private fun initData() {
    val book: Book = intent.getParcelableExtra(Constant.BOOK_DETAIL_EXTRA)
    presenter.getBookDetail(book.id)
    mOwnerAdapter.setItemUserClickListener(this)
  }

  fun onClickArrowBack(view: View) {
    mNavigator.finishActivity()
  }

  fun onClickSearch(view: View) {
    mNavigator.startActivity(SearchBookActivity::class.java)
  }
}
