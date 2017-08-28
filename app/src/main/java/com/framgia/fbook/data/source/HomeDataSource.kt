package com.framgia.fbook.data.source;

import com.framgia.fbook.data.model.BookType
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import io.reactivex.Single

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

public interface HomeDataSource {

  /**
   * RemoteData For Home
   */
  interface RemoteDataSource {
    fun getHome(officeId: Int?): Single<BaseResponse<List<BookType>>>
  }
}
