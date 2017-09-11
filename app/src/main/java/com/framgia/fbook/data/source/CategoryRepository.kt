package com.framgia.fbook.data.source

import com.framgia.fbook.data.model.Category
import com.framgia.fbook.data.source.remote.CategoryRemoteDataSource
import com.framgia.fbook.data.source.remote.api.response.BaseResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by levutantuan on 9/11/17.
 */
interface CategoryRepository : CategoryDateSource.CategoryRemoteDataSource

class CategoryRepositoryImpl @Inject constructor(
    private val categoryRemoteDataSource: CategoryRemoteDataSource) : CategoryRepository {
  override fun getCategory(): Single<BaseResponse<List<Category>>> {
    return categoryRemoteDataSource.getCategory()
  }
}
