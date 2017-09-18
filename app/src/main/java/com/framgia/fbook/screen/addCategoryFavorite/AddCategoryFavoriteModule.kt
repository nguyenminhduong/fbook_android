package com.framgia.fbook.screen.addCategoryFavorite;

import android.app.Activity
import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.CategoryRepositoryImpl
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.CategoryRemoteDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.navigator.Navigator
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import com.fstyle.structure_android.widget.dialog.DialogManager
import com.fstyle.structure_android.widget.dialog.DialogManagerImpl
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link AddCategoryFavoritePresenter}.
 */
@Module
class AddCategoryFavoriteModule(private val mActivity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(categoryRepository: CategoryRepository,
      baseSchedulerProvider: BaseSchedulerProvider): AddCategoryFavoriteContract.Presenter {
    val presenter = AddCategoryFavoritePresenter(categoryRepository)
    presenter.setSchedulerProvider(baseSchedulerProvider)
    presenter.setViewModel(mActivity as AddCategoryFavoriteContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideCategoryRepository(
      categoryRemoteDataSource: CategoryRemoteDataSource): CategoryRepository {
    return CategoryRepositoryImpl(categoryRemoteDataSource)
  }

  @ActivityScope
  @Provides
  fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource,
      userLocalDataSource: UserLocalDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource, userLocalDataSource)
  }

  @ActivityScope
  @Provides
  fun provideAddCategoryFavoriteAdapter(): AddCategoryFavoriteAdapter {
    return AddCategoryFavoriteAdapter(mActivity)
  }

  @ActivityScope
  @Provides
  fun provideDialogManager(): DialogManager {
    return DialogManagerImpl(mActivity)
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mActivity)
  }
}
