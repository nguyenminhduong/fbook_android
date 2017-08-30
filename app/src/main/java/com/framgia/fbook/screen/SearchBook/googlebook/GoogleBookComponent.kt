package com.framgia.fbook.screen.SearchBook.googlebook

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
    modules = arrayOf(GoogleBookModule::class))
interface GoogleBookComponent {
  fun inject(googlebookFragment: GoogleBookFragment)
}
