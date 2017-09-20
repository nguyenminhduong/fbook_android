package com.framgia.fbook.screen.bookdetail

import com.framgia.fbook.data.model.ActionBookDetail
import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.error.Type
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.ErrorResponse
import com.framgia.fbook.utils.rx.ImmediateSchedulerProvider
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by framgia on 20/09/2017.
 */
@RunWith(MockitoJUnitRunner::class)
class BookDetailPresenterTest {

  @InjectMocks
  lateinit var mPresenter: BookDetailPresenter
  @Mock
  lateinit var mViewModel: BookDetailActivity
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository

  private val mBookId: Int = 1
  private val mBookResponse: BaseResponse<Book> = BaseResponse()
  private val mBaseException = BaseException(Type.HTTP, ErrorResponse())
  private val mActionBookDetail = ActionBookDetail()

  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }


  @Test
  fun getBookDetail_shouldReturnInformationBook_whenGetBookDetail() {
    Mockito.`when`(mBookRepository.getBookDetail(mBookId)).thenReturn(
        Single.just(mBookResponse))
    mPresenter.getBookDetail(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onError(mBaseException)
    Mockito.verify(mViewModel).onGetBookDetailSuccess(mBookResponse.items)

  }

  @Test
  fun getBookDetail_shouldReturnError_whenGetBookDetail() {
    Mockito.`when`(mBookRepository.getBookDetail(mBookId)).thenReturn(Single.error(mBaseException))
    mPresenter.getBookDetail(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onGetBookDetailSuccess(mBookResponse.item)
    Mockito.verify(mViewModel).onError(mBaseException)
  }

  @Test
  fun addUserHaveThisBook_shouldReturnSuccess_whenAddUserHaveThisBook() {
    Mockito.`when`(mBookRepository.addUserHaveThisBook(mBookId)).thenReturn(
        Single.just(Any()))
    mPresenter.addUserHaveThisBook(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onError(mBaseException)
    Mockito.verify(mViewModel).onAddUserHaveThisBookSuccess()
  }

  @Test
  fun addUserHaveThisBook_shouldReturnError_whenAddUserHaveThisBook() {
    Mockito.`when`(mBookRepository.addUserHaveThisBook(mBookId)).thenReturn(
        Single.error(mBaseException))
    mPresenter.addUserHaveThisBook(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onAddUserHaveThisBookSuccess()
    Mockito.verify(mViewModel).onError(mBaseException)
  }

  @Test
  fun removeOwnerThisBook_shouldReturnSuccess_whenRemoveOwnerThisBook() {
    Mockito.`when`(mBookRepository.removeOwnerThisBook(mBookId)).thenReturn(
        Single.just(Any()))
    mPresenter.removeOwnerThisBook(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onError(mBaseException)
    Mockito.verify(mViewModel).onRemoveOwnerThisBookSuccess()
  }

  @Test
  fun removeOwnerThisBook_shouldReturnError_whenRemoveOwnerThisBook() {
    Mockito.`when`(mBookRepository.removeOwnerThisBook(mBookId)).thenReturn(
        Single.error(mBaseException))
    mPresenter.removeOwnerThisBook(mBookId)
    Mockito.verify(mViewModel, Mockito.never()).onRemoveOwnerThisBookSuccess()
    Mockito.verify(mViewModel).onError(mBaseException)
  }

  @Test
  fun readOrCancelBook_shouldReturnSuccess_whenReadOrCancelBook() {
    Mockito.`when`(mBookRepository.readOrCancelBook(mActionBookDetail)).thenReturn(
        Single.just(Any()))
    mPresenter.readOrCancelBook(mActionBookDetail)
    Mockito.verify(mViewModel, Mockito.never()).onError(mBaseException)
    Mockito.verify(mViewModel).onReadOrCancelBookSuccess()
  }

  @Test
  fun readOrCancelBook_shouldReturnError_whenReadOrCancelBook() {
    Mockito.`when`(mBookRepository.readOrCancelBook(mActionBookDetail)).thenReturn(
        Single.error(mBaseException))
    mPresenter.readOrCancelBook(mActionBookDetail)
    Mockito.verify(mViewModel, Mockito.never()).onReadOrCancelBookSuccess()
    Mockito.verify(mViewModel).onError(mBaseException)
  }
}
