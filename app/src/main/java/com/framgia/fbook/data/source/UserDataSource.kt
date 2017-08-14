package com.framgia.fbook.data.source

import com.framgia.fbook.data.model.User
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by le.quang.dao on 10/03/2017.
 */

interface UserDataSource {
  /**
   * LocalData For User
   */
  interface LocalDataSource : BaseLocalDataSource {

    fun insertUser(user: User): Completable

    fun updateUser(user: User): Completable

    fun deleteUser(user: User): Completable

    fun insertOrUpdateUser(user: User): Completable

    val allUser: Flowable<List<User>>

    fun getUserByUserLogin(userLogin: String): Single<User>
  }

  /**
   * RemoteData For User
   */
  interface RemoteDataSource {
    fun searchUsers(keyWord: String?, limit: Int): Single<List<User>>
    fun getUserDetailFromServer(userLogin: String?): Single<User>
  }
}
