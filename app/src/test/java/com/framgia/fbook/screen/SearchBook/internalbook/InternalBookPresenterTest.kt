package com.framgia.fbook.screen.SearchBook.internalbook

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.error.Type
import com.framgia.fbook.data.source.remote.api.request.SearchBookRequest
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
 * Created by Hyperion on 9/7/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
@RunWith(MockitoJUnitRunner::class)
class InternalBookPresenterTest {

  @InjectMocks
  lateinit var mPresenter: InternalBookPresenter
  @Mock
  lateinit var mViewModel: InternalBookFragment
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository
  val mKeyWord = "ab"
  val mField = "Title"

  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }

  @Test
  fun searchBook_shouldReturnListBook_whenSearchBook() {
    val searchData = SearchBookRequest.SearchBookData()
    val searchBookRequest = SearchBookRequest()
    val bookResponse: BaseResponse<BaseBookRespone<List<Book>>> = BaseResponse()
    searchData.keyWord = mKeyWord
    searchData.field = mField
    searchBookRequest.searchBookData = searchData
    Mockito.`when`(mBookRepository.searchBook(mKeyWord, mField)).thenReturn(
        Single.just(bookResponse))
    mPresenter.searchBook(mKeyWord, mField)
    Mockito.verify(mViewModel).onSearchBookSuccess(bookResponse.items?.data)
  }

  @Test(expected = BaseException::class)
  fun searchBook_shouldReturnError_whenSearchBook() {
    val baseException = BaseException(Type.HTTP, ErrorResponse())
    Mockito.`when`(mBookRepository.searchBook(mKeyWord, mField)).thenThrow(baseException)
    mPresenter.searchBook(mKeyWord, mField)
    Mockito.verify(mViewModel).onError(baseException)
  }
}
