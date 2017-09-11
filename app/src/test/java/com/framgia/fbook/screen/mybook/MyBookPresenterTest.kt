package com.framgia.fbook.screen.mybook

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.error.Type
import com.framgia.fbook.data.source.remote.api.response.BaseBookRespone
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
 * Created by framgia on 11/09/2017.
 */
@RunWith(MockitoJUnitRunner::class)
class MyBookPresenterTest {

  @InjectMocks
  lateinit var mPresenter: MyBookPresenter
  @Mock
  lateinit var mViewModel: MyBookFragment
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository
  private val mUserId: Int = 3

  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }

  @Test
  fun getMyBook_shouldReturnLisMytBook_whenGetMyBook() {
    val bookResponse: BaseResponse<BaseBookRespone<List<Book>>> = BaseResponse()
    Mockito.`when`(mBookRepository.getMyBook(mUserId)).thenReturn(
        Single.just(bookResponse))
    mPresenter.getMyBook(mUserId)
    Mockito.verify(mViewModel).onGetMyBookSuccess(bookResponse.items?.data)
  }

  @Test(expected = BaseException::class)
  fun getMyBook_shouldReturnError_whenGetMyBook() {
    val baseException = BaseException(Type.HTTP, ErrorResponse())
    Mockito.`when`(mBookRepository.getMyBook(mUserId)).thenThrow(baseException)
    mPresenter.getMyBook(mUserId)
    Mockito.verify(mViewModel).onError(baseException)
  }
}
