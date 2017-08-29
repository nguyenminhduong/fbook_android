package com.framgia.fbook.data.source

import com.framgia.fbook.data.model.BookType
import com.framgia.fbook.data.source.remote.HomeRemoteDataSource
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */
interface HomeRepository : HomeDataSource.RemoteDataSource

class HomeRepositoryImpl @Inject constructor(
    val remoteDataSource: HomeRemoteDataSource) : HomeRepository {

  override fun getHome(officeId: Int?): Single<BaseResponse<List<BookType>>> {
    return remoteDataSource.getHome(officeId)
  }
}
