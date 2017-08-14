package com.framgia.fbook.screen.main

import com.framgia.fbook.AppComponent
import com.framgia.fbook.utils.dagger.ActivityScope
import dagger.Component

/**
 * Created by daolq on 8/14/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
  fun inject(mainActivity: MainActivity)
}
