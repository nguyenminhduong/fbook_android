package com.framgia.fbook.screen.sharebook

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.databinding.ActivitySharebookBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import java.io.File
import javax.inject.Inject


/**
 * ShareBook Screen.
 */
class ShareBookActivity : BaseActivity(), ShareBookContract.ViewModel, ItemImageSelectedListener {
  @Inject
  internal lateinit var mPresenter: ShareBookContract.Presenter
  @Inject
  lateinit var mNavigator: Navigator
  @Inject
  internal lateinit var mImageSelectedAdapter: ImageSelectedAdapter
  val mBookRequest = BookRequest()

  val titleError: ObservableField<String> = ObservableField()
  val authorError: ObservableField<String> = ObservableField()
  val descriptionError: ObservableField<String> = ObservableField()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerShareBookComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .shareBookModule(ShareBookModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivitySharebookBinding>(this,
        R.layout.activity_sharebook)
    binding.viewModel = this

    EasyImage.configuration(this).setAllowMultiplePickInGallery(true)
    mImageSelectedAdapter.setItemImageSelectedListener(this)
    mBookRequest.listImage = mImageSelectedAdapter.mListImage
  }

  override fun onInputAuthorError(errorMsg: String?) {
    authorError.set(errorMsg)
  }

  override fun onInputDescriptionError(errorMsg: String?) {
    descriptionError.set(errorMsg)
  }

  override fun onInputTitleError(errorMsg: String?) {
    titleError.set(errorMsg)
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    EasyImage.handleActivityResult(requestCode, resultCode, data, this, object : DefaultCallback() {
      override fun onImagePickerError(e: Exception?, source: EasyImage.ImageSource?, type: Int) {
      }

      override fun onImagesPicked(imagesFiles: List<File>, source: EasyImage.ImageSource,
          type: Int) {
        updateDataImage(imagesFiles)
      }
    })
  }

  override fun onRemoveSelected(image: BookRequest.Image) {
    mImageSelectedAdapter.removeOneItem(image)
  }

  private fun updateDataImage(images: List<File>) {
    val listImage = mutableListOf<BookRequest.Image>()
    for (image in images) {
      val imageSelected: BookRequest.Image = BookRequest.Image()
      imageSelected.image = image
      listImage.add(imageSelected)
    }
    mImageSelectedAdapter.updateData(listImage)
  }

  fun onClickArrowBack() {
    mNavigator.finishActivity()
  }

  fun onClickCreateBook() {
    if (!mPresenter.validateDataInput(mBookRequest)) {
      return
    }
    //todo request server
  }

  fun onClickAddImage() {
    EasyImage.openChooserWithGallery(this, getString(R.string.select_image_from_gallery_or_camera),
        0)
  }

}
