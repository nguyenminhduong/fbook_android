package com.framgia.fbook.screen.sharebook

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.error.Type
import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.ErrorResponse
import com.framgia.fbook.utils.rx.ImmediateSchedulerProvider
import com.framgia.fbook.utils.validator.Validator
import io.reactivex.Single
import org.junit.Assert
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
class ShareBookPresenterTest {
  @InjectMocks
  lateinit var mPresenter: ShareBookPresenter
  @Mock
  lateinit var mViewModel: ShareBookActivity
  @InjectMocks
  lateinit var mBaseSchedulerProvider: ImmediateSchedulerProvider
  @Mock
  lateinit var mBookRepository: BookRepository
  @Mock
  lateinit var mUserRepository: UserRepository
  @Mock
  lateinit var mCategoryRepository: CategoryRepository
  @Mock
  lateinit var mValidator: Validator

  @Before
  fun setUp() {
    mPresenter.setViewModel(mViewModel)
    mPresenter.setSchedulerProvider(mBaseSchedulerProvider)
  }

  @Test
  fun validateDataInput_ShouldReturnTrue_whenInputValidData() {
    val expect = true
    val bookRequest = BookRequest()
    bookRequest.title = "harry"
    bookRequest.author = "harry"
    bookRequest.description = "harry"
    bookRequest.categoryId = 1
    bookRequest.officeId = 1
    bookRequest.publishDate = "2017-01-01"
    Mockito.`when`(mValidator.validateAll(bookRequest)).thenReturn(expect)
    val result = mPresenter.validateDataInput(bookRequest)
    Assert.assertEquals(expect, result)
  }

  @Test
  fun validateDataInput_ShouldReturnFalse_whenTitleEmpty() {
    val expect = false
    val bookRequest = BookRequest()
    bookRequest.author = "harry"
    bookRequest.description = "harry"
    bookRequest.categoryId = 1
    bookRequest.officeId = 1
    bookRequest.publishDate = "2017-01-01"
    Mockito.`when`(mValidator.validateAll(bookRequest)).thenReturn(expect)
    val result = mPresenter.validateDataInput(bookRequest)
    Assert.assertEquals(expect, result)
  }

  @Test
  fun validateDataInput_ShouldReturnFalse_whenAuthorEmpty() {
    val expect = false
    val bookRequest = BookRequest()
    bookRequest.title = "harry"
    bookRequest.description = "harry"
    bookRequest.categoryId = 1
    bookRequest.officeId = 1
    bookRequest.publishDate = "2017-01-01"
    Mockito.`when`(mValidator.validateAll(bookRequest)).thenReturn(expect)
    val result = mPresenter.validateDataInput(bookRequest)
    Assert.assertEquals(expect, result)
  }

  @Test
  fun validateDataInput_ShouldReturnFalse_whenDescriptionEmpty() {
    val expect = false
    val bookRequest = BookRequest()
    bookRequest.title = "harry"
    bookRequest.author = "harry"
    bookRequest.categoryId = 1
    bookRequest.officeId = 1
    bookRequest.publishDate = "2017-01-01"
    Mockito.`when`(mValidator.validateAll(bookRequest)).thenReturn(expect)
    val result = mPresenter.validateDataInput(bookRequest)
    Assert.assertEquals(expect, result)
  }

  @Test
  fun getMyBook_shouldReturnBook_whenAddBookSuccess() {
    val bookResponse: BaseResponse<Book> = BaseResponse()
    val bookRequest = BookRequest()
    bookRequest.title = "harry"
    bookRequest.author = "harry"
    bookRequest.description = "harry"
    bookRequest.categoryId = 1
    bookRequest.officeId = 1
    bookRequest.publishDate = "2017-01-01"
    Mockito.`when`(mBookRepository.addBook(bookRequest)).thenReturn(
        Single.just(bookResponse))
    mPresenter.addBook(bookRequest)
    Mockito.verify(mViewModel).onAddBookSuccess(bookResponse.item)
  }

  @Test(expected = BaseException::class)
  fun getMyBook_shouldReturnError_whenAddBookError() {
    val bookRequest = BookRequest()
    val baseException = BaseException(Type.HTTP, ErrorResponse())
    Mockito.`when`(mBookRepository.addBook(bookRequest)).thenThrow(baseException)
    mPresenter.addBook(bookRequest)
    Mockito.verify(mViewModel).onError(baseException)
  }
}
