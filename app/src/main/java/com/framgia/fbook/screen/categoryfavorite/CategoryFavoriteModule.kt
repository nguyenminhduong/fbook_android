package com.framgia.fbook.screen.categoryfavorite

import android.support.v4.app.Fragment
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [CategoryFavoritePresenter].
 */
@Module
class CategoryFavoriteModule(private val fragment: Fragment) {

  @FragmentScope
  @Provides
  internal fun providePresenter(): CategoryFavoriteContract.Presenter {
    return CategoryFavoritePresenter()
  }

  @FragmentScope
  @Provides
  fun provideCategoryAdapter(): CategoryAdapter {
    return CategoryAdapter(fragment.context)
  }

  @FragmentScope
  @Provides
  fun providerUserRepository(userRemoteDataSource: UserRemoteDataSource,
      userLocalDataSource: UserLocalDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource, userLocalDataSource)
  }
}
