package com.framgia.fbook.screen.SearchBook;

import com.framgia.fbook.AppComponent
import com.framgia.fbook.data.source.remote.api.service.FBookApi
import com.framgia.fbook.utils.dagger.ActivityScope
import com.framgia.fbook.utils.rx.BaseSchedulerProvider
import dagger.Component

/**
 * This is a Dagger component. Refer to {@link com.framgia.fbook.screen.MainApplication} for the list of Dagger components
 * used in this application.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(SearchBookModule::class))
interface SearchBookComponent {
  fun inject(searchbookActivity: SearchBookActivity)

  fun fbookApi(): FBookApi

  fun baseSchedulerProvider(): BaseSchedulerProvider
}
