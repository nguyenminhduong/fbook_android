package com.framgia.fbook.data.source.remote

import com.framgia.fbook.data.model.BookType
import com.framgia.fbook.data.source.HomeDataSource
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import com.framgia.fbook.data.source.remote.api.service.FBookApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */
class HomeRemoteDataSource @Inject
constructor(nameApi: FBookApi) : BaseRemoteDataSource(nameApi), HomeDataSource.RemoteDataSource {

  override fun getHome(officeId: Int?): Single<BaseResponse<List<BookType>>> {
    return fbookApi.getHome(officeId)
  }
}
