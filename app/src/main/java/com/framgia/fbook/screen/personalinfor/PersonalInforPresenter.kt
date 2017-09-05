package com.framgia.fbook.screen.personalinfor

/**
 * Listens to user actions from the UI ([PersonalInforFragment]), retrieves the data and
 * updates
 * the UI as required.
 */
class PersonalInforPresenter : PersonalInforContract.Presenter {

  private var mViewModel: PersonalInforContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: PersonalInforContract.ViewModel) {
    mViewModel = viewModel
  }

  companion object {
    private val TAG = PersonalInforPresenter::class.java.name
  }
}
