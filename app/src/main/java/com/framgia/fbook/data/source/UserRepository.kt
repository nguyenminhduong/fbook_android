package com.framgia.fbook.data.source

import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.response.SignInResponse
import io.reactivex.Single

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface UserRepository : UserDataSource.RemoteDataSource, UserDataSource.LocalDataSource

open class UserRepositoryImpl(private val mRemoteDataSource: UserRemoteDataSource,
    private val mLocalDataSource: UserLocalDataSource) : UserRepository {

  override fun login(email: String?, password: String?): Single<SignInResponse> {
    return mRemoteDataSource.login(email, password)
  }

  override fun getUser(authorization: String?): Single<BaseResponse<User>> {
    return mRemoteDataSource.getUser(authorization)
  }

  override fun saveUser(user: User?) {
    mLocalDataSource.saveUser(user)
  }

  override fun getUserLocal(): Single<User> {
    return mLocalDataSource.getUserLocal()
  }

  override fun clearData() {
    mLocalDataSource.clearData()
  }

}
