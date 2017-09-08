package com.framgia.fbook.data.source.remote

import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.UserDataSource
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import com.framgia.fbook.data.source.remote.api.service.FBookApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by le.quang.dao on 10/03/2017.
 */

class UserRemoteDataSource @Inject
constructor(nameApi: FBookApi) : BaseRemoteDataSource(nameApi), UserDataSource.RemoteDataSource {
  override fun login(email: String?, password: String?): Single<SignInResponse> {
    val signInRequest = SignInRequest()
    signInRequest.email = email
    signInRequest.password = password
    return fbookApi.login(signInRequest)
  }

  override fun getUser(): Single<BaseResponse<User>> {
    return fbookApi.getUser()
  }
}
