package com.framgia.fbook.screen.userinbookdetail.screen.UserReview

import com.framgia.fbook.screen.userinbookdetail.UserInBookDetailComponent
import com.framgia.fbook.utils.dagger.FragmentScope
import dagger.Component

/**
 * This is a Dagger component. Refer to
 * [com.framgia.fbook.screen.userinbookdetail.MainApplication]
 * for the list of Dagger components
 * used in this application.
 */
@FragmentScope
@Component(dependencies = arrayOf(UserInBookDetailComponent::class),
    modules = arrayOf(UserReviewModule::class))
interface UserReviewComponent {
  fun inject(userReviewFragment: UserReviewFragment)
}

