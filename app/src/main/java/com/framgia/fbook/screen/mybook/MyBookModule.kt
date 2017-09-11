package com.framgia.fbook.screen.mybook

import android.support.v4.app.Fragment
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.BookRepositoryImpl
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.UserRepositoryImpl
import com.framgia.fbook.data.source.local.UserLocalDataSource
import com.framgia.fbook.data.source.remote.BookRemoteDataSource
import com.framgia.fbook.data.source.remote.UserRemoteDataSource
import com.framgia.fbook.utils.dagger.FragmentScope
import com.framgia.fbook.utils.navigator.Navigator
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import com.fstyle.structure_android.widget.dialog.DialogManager
import com.fstyle.structure_android.widget.dialog.DialogManagerImpl
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [MyBookPresenter].
 */
@Module
class MyBookModule(private val mFragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(bookRepository: BookRepository,
      basesShedulerProvider: BaseSchedulerProvider): MyBookContract.Presenter {
    val presenter = MyBookPresenter(bookRepository)
    presenter.setSchedulerProvider(basesShedulerProvider)
    presenter.setViewModel(mFragment as MyBookContract.ViewModel)
    return presenter
  }

  @FragmentScope
  @Provides
  fun provideBookRepository(bookRemoteDataSource: BookRemoteDataSource): BookRepository {
    return BookRepositoryImpl(bookRemoteDataSource)
  }

  @FragmentScope
  @Provides
  fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource,
      userLocalDataSource: UserLocalDataSource): UserRepository {
    return UserRepositoryImpl(userRemoteDataSource, userLocalDataSource)
  }

  @FragmentScope
  @Provides
  fun provideMyBookAdapter(): MyBookAdapter {
    return MyBookAdapter(mFragment.context)
  }

  @FragmentScope
  @Provides
  fun provideDialogManager(): DialogManager {
    return DialogManagerImpl(mFragment.context)
  }

  @FragmentScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mFragment)
  }
}
