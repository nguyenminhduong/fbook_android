package com.framgia.fbook.screen.userinbookdetail;

import android.app.Activity
import android.support.v4.app.FragmentActivity
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.BookRepositoryImpl
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.BookRemoteDataSource
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
 * the {@link UserInBookDetailPresenter}.
 */
@Module
class UserInBookDetailModule(private val activity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(bookRepository: BookRepository,
      basesShedulerProvider: BaseSchedulerProvider): UserInBookDetailContract.Presenter {
    val presenter = UserInBookDetailPresenter(bookRepository)
    presenter.setSchedulerProvider(basesShedulerProvider)
    presenter.setViewModel(activity as UserInBookDetailContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideBookRepository(bookRemoteDataSource: BookRemoteDataSource): BookRepository {
    return BookRepositoryImpl(bookRemoteDataSource)
  }

  @ActivityScope
  @Provides
  fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource,
      userLocalDataSource: UserLocalDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource, userLocalDataSource)
  }

  @ActivityScope
  @Provides
  fun provideUserInBookDetailAdapter(): UserInBookDetailAdapter {
    return UserInBookDetailAdapter(activity, (activity as FragmentActivity).supportFragmentManager)
  }

  @ActivityScope
  @Provides
  fun provideDialogManager(): DialogManager {
    return DialogManagerImpl(activity)
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(activity)
  }
}
