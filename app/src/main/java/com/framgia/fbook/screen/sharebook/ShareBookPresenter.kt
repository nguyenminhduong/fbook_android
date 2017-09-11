package com.framgia.fbook.screen.sharebook;

import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.utils.common.StringUtils
import com.framgia.fbook.utils.validator.Validator

/**
 * Listens to user actions from the UI ({@link ShareBookActivity}), retrieves the data and updates
 * the UI as required.
 */
class ShareBookPresenter(private val mValidator: Validator) : ShareBookContract.Presenter {
  companion object {
    private val TAG = ShareBookPresenter::class.java.name
  }

  private var mViewModel: ShareBookContract.ViewModel? = null

  override fun onStart() {}

  override fun onStop() {}

  override fun setViewModel(viewModel: ShareBookContract.ViewModel) {
    mViewModel = viewModel
  }

  override fun validateDataInput(bookRequest: BookRequest): Boolean {
    validateTitleInput(bookRequest.title)
    validateAuthorInput(bookRequest.author)
    validateDescriptionInput(bookRequest.description)
    return mValidator.validateAll(bookRequest)
  }

  private fun validateTitleInput(title: String?) {
    var message: String? = mValidator.validateValueNonEmpty(title)
    if (!StringUtils.isBlank(message)) {
      mViewModel?.onInputTitleError(message)
    }
  }

  private fun validateAuthorInput(author: String?) {
    var message: String? = mValidator.validateValueNonEmpty(author)
    if (!StringUtils.isBlank(message)) {
      mViewModel?.onInputAuthorError(message)
    }
  }

  private fun validateDescriptionInput(description: String?) {
    var message: String? = mValidator.validateValueNonEmpty(description)
    if (!StringUtils.isBlank(message)) {
      mViewModel?.onInputDescriptionError(message)
    }
  }
}
