package com.fstyle.fbook.data.source

import com.fstyle.fbook.data.model.User
import com.fstyle.fbook.data.source.remote.UserRemoteDataSource
import io.reactivex.Single

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface UserRepository : UserDataSource.RemoteDataSource

class UserRepositoryImpl(val remoteDataSource: UserRemoteDataSource) : UserRepository {

  override fun searchUsers(keyWord: String?, limit: Int): Single<List<User>> {
    return remoteDataSource.searchUsers(keyWord, limit)
  }

  override fun getUserDetailFromServer(userLogin: String?): Single<User> {
    return remoteDataSource.getUserDetailFromServer(userLogin)
  }
}
