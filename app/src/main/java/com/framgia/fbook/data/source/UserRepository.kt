package com.framgia.fbook.data.source

import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.data.source.remote.api.request.SignInRequest
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import io.reactivex.Single

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface UserRepository : UserDataSource.RemoteDataSource

class UserRepositoryImpl(val remoteDataSource: UserRemoteDataSource) : UserRepository {

  override fun login(signInRequest: SignInRequest?): Single<SignInResponse> {
    return remoteDataSource.login(signInRequest)
  }

  override fun searchUsers(keyWord: String?, limit: Int): Single<List<User>> {
    return remoteDataSource.searchUsers(keyWord, limit)
  }

  override fun getUserDetailFromServer(userLogin: String?): Single<User> {
    return remoteDataSource.getUserDetailFromServer(userLogin)
  }
}
