package com.framgia.fbook.screen.bookdetail;

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.view.View
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.model.ActionBookDetail
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.Owner
import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.ActivityBookdetailBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.screen.SearchBook.SearchBookActivity
import com.framgia.fbook.screen.login.LoginActivity
import com.framgia.fbook.utils.Constant
import com.framgia.fbook.utils.navigator.Navigator
import com.fstyle.library.MaterialDialog
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * BookDetail Screen.
 */
open class BookDetailActivity : BaseActivity(), BookDetailContract.ViewModel, ItemOwnerClickListener {

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
  @Inject
  internal lateinit var mUserRepository: UserRepository

  val mIsUserHaveThisBook: ObservableField<Boolean> = ObservableField()
  val mIsUserWaitingThisBook: ObservableField<Boolean> = ObservableField()
  val mBook: ObservableField<Book> = ObservableField()
  val mCoverBook: ObservableField<String> = ObservableField()
  val mNumberOfReViewDetail: ObservableField<Int> = ObservableField()
  val mNumberOfWaiting: ObservableField<Int> = ObservableField()
  val mNumberOfReading: ObservableField<Int> = ObservableField()
  val mNumberOfReturning: ObservableField<Int> = ObservableField()
  val mNumberOfReturned: ObservableField<Int> = ObservableField()
  private var mUserId: Int? = null
  private var mBookId: Int? = null
  private var mOwners = arrayListOf<Owner>()
  private var mUserWaitings = arrayListOf<User>()
  private var mActionBookDetail = ActionBookDetail()

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

      book.images?.let {
        if (it.isNotEmpty()) {
          mCoverBook.set(it[0].mobileImage?.smallPath)
        }
      }

      book.owners?.let {
        mOwners.clear()
        mOwners.addAll(it)
        checkUserIsHaveThisBook(it)
      }

      book.usersWaitings?.let {
        mUserWaitings.clear()
        mUserWaitings.addAll(it)
        checkUserIsWaitingThisBook(it)
      }
    }
  }

  override fun onError(e: BaseException) {
    mDialogManager.dialogError(e.getMessageError())
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onReadOrCancelBookSuccess() {
    mIsUserWaitingThisBook.set(true)
    presenter.getBookDetail(mBookId)
  }

  override fun onRemoveOwnerThisBookSuccess() {
    mIsUserHaveThisBook.set(false)
    presenter.getBookDetail(mBookId)
  }

  override fun onAddUserHaveThisBookSuccess() {
    mIsUserHaveThisBook.set(true)
    presenter.getBookDetail(mBookId)
  }

  override fun onItemOwnerClick(owner: Owner?) {
    //TODO edit later
  }

  private fun initData() {
    val book: Book = intent.getParcelableExtra(Constant.BOOK_DETAIL_EXTRA)
    mBookId = book.id
    mActionBookDetail.bookId = mBookId
    presenter.getBookDetail(mBookId)
    mOwnerAdapter.setItemUserClickListener(this)
    mUserRepository.getUserLocal()?.let {
      mUserId = it.id
    }
  }

  private fun checkUserIsHaveThisBook(owners: List<Owner>) {
    var userHaveThisBook = false
    if (owners.isNotEmpty()) {
      for (owner in owners.iterator()) {
        if (owner.id == mUserId) {
          userHaveThisBook = true
          break
        }
      }
    }
    return mIsUserHaveThisBook.set(userHaveThisBook)
  }

  private fun checkUserIsWaitingThisBook(users: List<User>) {
    var userWaitingThisBook = false
    if (users.isNotEmpty()) {
      for (user in users.iterator()) {
        if (user.id == mUserId) {
          userWaitingThisBook = true
          break
        }
      }
    }
    return mIsUserWaitingThisBook.set(userWaitingThisBook)
  }

  fun onClickArrowBack(view: View) {
    mNavigator.finishActivity()
  }

  fun onClickSearch(view: View) {
    mNavigator.startActivity(SearchBookActivity::class.java)
  }

  fun onClickUserHaveThisBook(view: View) {
    mDialogManager.dialogBasic(getString(R.string.inform),
        getString(R.string.are_you_sure_add_owner_this_book),
        MaterialDialog.SingleButtonCallback { materialDialog, dialogAction ->
          presenter.addUserHaveThisBook(mBookId)
        })
  }

  fun onClickRemoveOwnerThisBook(view: View) {
    mDialogManager.dialogBasic(getString(R.string.inform),
        getString(R.string.are_you_sure_remove_owner_this_book),
        MaterialDialog.SingleButtonCallback { materialDialog, dialogAction ->
          presenter.removeOwnerThisBook(mBookId)
        })
  }

  fun onClickWantToReadingBook(view: View) {
    mActionBookDetail.status = Status.WANT_TO_READ_THIS_BOOK.value

    val ownerNames: MutableList<String?> = mutableListOf()
    mOwners.mapTo(ownerNames) { it.name }

    if (ownerNames.isEmpty()) {
      mDialogManager.dialogError(getString(R.string.this_book_does_not_have_the_owner))
      return
    }

    mDialogManager.dialogListSingleChoice(getString(R.string.do_you_want_to_read_this_book),
        ownerNames, 0, MaterialDialog.ListCallbackSingleChoice({ _, _, position, _ ->
      val currentOwnerId = (mOwners[position]).id
      if (mUserId == currentOwnerId) {
        mDialogManager.dialogError(getString(R.string.you_already_own_this_book))
      } else {
        mActionBookDetail.ownerId = currentOwnerId
        presenter.readOrCancelBook(mActionBookDetail)
      }
      true
    }))
  }

  fun onClickCancelWaitingBook(view: View) {
    mActionBookDetail.status = Status.CANCEL_WAITING_THIS_BOOK.value

    mUserWaitings.forEach { userWaiting ->
      if (mUserId == userWaiting.id) {
        mActionBookDetail.ownerId = userWaiting.ownerId
      }
    }

    mDialogManager.dialogBasic(getString(R.string.inform),
        getString(R.string.do_you_want_cancel_waiting_this_book),
        MaterialDialog.SingleButtonCallback { materialDialog, dialogAction ->
          presenter.readOrCancelBook(mActionBookDetail)
        })
  }

  enum class Status(val value: Int) {
    WANT_TO_READ_THIS_BOOK(1),
    CANCEL_WAITING_THIS_BOOK(5)
  }
}
