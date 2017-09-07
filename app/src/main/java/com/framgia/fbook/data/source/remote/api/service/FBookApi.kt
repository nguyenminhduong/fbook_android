package com.framgia.fbook.data.source.remote.api.service

import com.framgia.fbook.data.model.Book
import com.framgia.fbook.data.model.BookType
import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.remote.api.request.SearchBookRequest
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.BaseBookRespone
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface FBookApi {
  @GET("/api/v0/home/")
  fun getHome(@Query("office_id") officeId: Int?): Single<BaseResponse<List<BookType>>>

  @POST("/api/v0/login")
  fun login(@Body signInRequest: SignInRequest?): Single<SignInResponse>

  @POST("/api/v0/search")
  fun searchBook(@Body searchBookRequest: SearchBookRequest): Single<BaseResponse<BaseBookRespone<List<Book>>>>

  @GET("/api/v0/user-profile")
  fun getUser(@Header("Authorization") authorization: String?): Single<BaseResponse<User>>
}
