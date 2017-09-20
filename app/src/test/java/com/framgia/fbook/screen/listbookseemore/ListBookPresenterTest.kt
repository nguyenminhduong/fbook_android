package com.framgia.fbook.screen.listbookseemore

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.error.Type
import com.framgia.fbook.data.source.remote.api.response.BaseBookRespone
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.ErrorResponse
import com.framgia.fbook.utils.Constant
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
 * Created by Hyperion on 9/14/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
@RunWith(MockitoJUnitRunner::class)
class ListBookPresenterTest {

  @InjectMocks
  lateinit var mPresenter: ListBookPresenter
  @Mock
  lateinit var mViewModel: ListBookFragment
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository
  @Mock
  lateinit var mCategoryRepository: CategoryRepository
  private val listResponse: BaseResponse<BaseBookRespone<List<Book>>> = BaseResponse()
  private val baseException = BaseException(Type.HTTP, ErrorResponse())

  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }

  @Test
  fun getListBook_shouldReturnListLateBook_whenTypeBookIsLate() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.LATE, Constant.PAGE))
        .thenReturn(Single.just(listResponse))
    mPresenter.getListBook(Constant.LATE, Constant.PAGE)
    Mockito.verify(mViewModel).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel, Mockito.never()).onError(baseException)
  }

  @Test
  fun getListBook_shouldReturnListRatingBook_whenTypeBookIsRating() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.RATING, Constant.PAGE))
        .thenReturn(Single.just(listResponse))
    mPresenter.getListBook(Constant.RATING, Constant.PAGE)
    Mockito.verify(mViewModel).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel, Mockito.never()).onError(baseException)
  }

  @Test
  fun getListBook_shouldReturnListViewBook_whenTypeBookIsView() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.VIEW, Constant.PAGE))
        .thenReturn(Single.just(listResponse))
    mPresenter.getListBook(Constant.VIEW, Constant.PAGE)
    Mockito.verify(mViewModel).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel, Mockito.never()).onError(baseException)
  }

  @Test
  fun getListBook_shouldReturnListLWaitingBook_whenTypeBookIsWaiting() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.WAITING, Constant.PAGE))
        .thenReturn(Single.just(listResponse))
    mPresenter.getListBook(Constant.WAITING, Constant.PAGE)
    Mockito.verify(mViewModel).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel, Mockito.never()).onError(baseException)
  }

  @Test
  fun getListBook_shouldReturnListReadBook_whenTypeBookIsRead() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.READ, Constant.PAGE))
        .thenReturn(Single.just(listResponse))
    mPresenter.getListBook(Constant.READ, Constant.PAGE)
    Mockito.verify(mViewModel).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel, Mockito.never()).onError(baseException)
  }

  @Test(expected = BaseException::class)
  fun getListBook_shouldReturnError_whenGetListBook() {
    Mockito.`when`(mBookRepository.getSectionListBook(Constant.READ, Constant.PAGE))
        .thenThrow(baseException)
    mPresenter.getListBook(Constant.READ, Constant.PAGE)
    Mockito.verify(mViewModel, Mockito.never()).onGetListBookSuccess(listResponse.item?.data)
    Mockito.verify(mViewModel).onError(baseException)
  }
}
