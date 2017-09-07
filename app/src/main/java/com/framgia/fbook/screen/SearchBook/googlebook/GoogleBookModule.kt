package com.framgia.fbook.screen.SearchBook.googlebook

import android.support.v4.app.Fragment
import com.framgia.fbook.data.source.BookRepository
import com.framgia.fbook.data.source.BookRepositoryImpl
import com.framgia.fbook.data.source.remote.BookRemoteDataSource
import com.framgia.fbook.utils.dagger.FragmentScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import com.fstyle.structure_android.widget.dialog.DialogManager
import com.fstyle.structure_android.widget.dialog.DialogManagerImpl
import dagger.Module
import dagger.Provides

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the [GoogleBookPresenter].
 */
@Module
class GoogleBookModule(private val mFragment: Fragment) {

  @FragmentScope
  @Provides
  fun providePresenter(bookRepository: BookRepository,
      schedulerProvider: BaseSchedulerProvider): GoogleBookContract.Presenter {
    val presenter = GoogleBookPresenter(bookRepository)
    presenter.setViewModel(mFragment as GoogleBookContract.ViewModel)
    presenter.setSchedulerProvider(schedulerProvider)
    return presenter
  }

  @FragmentScope
  @Provides
  fun provideBookRepository(bookRemoteDataSource: BookRemoteDataSource): BookRepository {
    return BookRepositoryImpl(bookRemoteDataSource)
  }

  @FragmentScope
  @Provides
  fun provideDialogManager(): DialogManager {
    return DialogManagerImpl(mFragment.context)
  }
}
