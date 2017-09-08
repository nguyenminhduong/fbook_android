package com.framgia.fbook.screen.SearchBook.googlebook

import com.framgia.fbook.data.model.GoogleBook
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
 * Created by Hyperion on 9/8/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
@RunWith(MockitoJUnitRunner::class)
class GoogleBookPresenterTest {
  @InjectMocks
  lateinit var mPresenter: GoogleBookPresenter
  @Mock
  lateinit var mViewModel: GoogleBookFragment
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository
  val keySearch = "hello"
  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }

  @Test
  fun searchBook_shouldReturnListBook_whenSearchBook() {
    val listResponse: BaseResponse<List<GoogleBook>> = BaseResponse()
    Mockito.`when`(mBookRepository.searchBookWithGoogleApi(keySearch)).thenReturn(
        Single.just(listResponse))
    mPresenter.searchBook(keySearch)
    Mockito.verify(mViewModel).onSearchBookSuccess(listResponse.items)
  }

  @Test(expected = BaseException::class)
  fun searchBook_shouldReturnError_whenSearchBook() {
    val baseException = BaseException(Type.HTTP, ErrorResponse())
    Mockito.`when`(mBookRepository.searchBookWithGoogleApi(keySearch)).thenThrow(baseException)
    mPresenter.searchBook(keySearch)
    Mockito.verify(mViewModel).onError(baseException)
  }
}
