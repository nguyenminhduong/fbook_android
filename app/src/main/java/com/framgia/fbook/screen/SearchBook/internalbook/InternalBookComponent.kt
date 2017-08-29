package com.framgia.fbook.screen.SearchBook.internalbook

import com.framgia.fbook.screen.SearchBook.SearchBookComponent
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Component

/**
 * This is a Dagger component. Refer to [com.framgia.fbook.screen.SearchBook.MainApplication]
 * for the list of Dagger components
 * used in this application.
 */
@FragmentScope
@Component(dependencies = arrayOf(SearchBookComponent::class),
    modules = arrayOf(InternalBookModule::class))
interface InternalBookComponent {
  fun inject(internalbookFragment: InternalBookFragment)
}
