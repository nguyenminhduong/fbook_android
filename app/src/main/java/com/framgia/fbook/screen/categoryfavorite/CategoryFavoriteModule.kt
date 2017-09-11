package com.framgia.fbook.screen.categoryfavorite

import android.support.v4.app.Fragment
import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.CategoryRepositoryImpl
import com.framgia.fbook.data.source.remote.CategoryRemoteDataSource
import com.framgia.fbook.utils.dagger.FragmentScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
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
  internal fun providePresenter(schedulerProvider: BaseSchedulerProvider,
      categoryRepository: CategoryRepository): CategoryFavoriteContract.Presenter {
    val presenter = CategoryFavoritePresenter(categoryRepository)
    presenter.setViewModel(fragment as CategoryFavoriteContract.ViewModel)
    presenter.setSchedulerProvider(schedulerProvider)
    return presenter
  }

  @FragmentScope
  @Provides
  fun provideCategoryRepository(
      categoryRemoteDataSource: CategoryRemoteDataSource): CategoryRepository {
    return CategoryRepositoryImpl(categoryRemoteDataSource)
  }

  @FragmentScope
  @Provides
  fun provideCategoryAdapter(): CategoryAdapter {
    return CategoryAdapter(fragment.context)
  }
}
