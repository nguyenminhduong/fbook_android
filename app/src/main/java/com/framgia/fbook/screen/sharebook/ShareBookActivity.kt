package com.framgia.fbook.screen.sharebook

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Office
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.data.source.remote.api.request.BookRequest
import com.framgia.fbook.databinding.ActivitySharebookBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import com.fstyle.library.MaterialDialog
import com.fstyle.structure_android.widget.dialog.DialogManager
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
  internal lateinit var mDialogManager: DialogManager
  @Inject
  internal lateinit var mImageSelectedAdapter: ImageSelectedAdapter
  val mBookRequest = BookRequest()
  private val mListOffice = mutableListOf<Office>()

  val titleError: ObservableField<String> = ObservableField()
  val authorError: ObservableField<String> = ObservableField()
  val descriptionError: ObservableField<String> = ObservableField()
  var currentOffice: ObservableField<String> = ObservableField()
  private var currentOfficePosition: Int = 0

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
    mPresenter.getData()
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

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onGetOfficeSuccess(listOffice: List<Office>?) {
    mListOffice.addAll(listOffice!!)
    updateCurrentOffice(currentOfficePosition)
  }

  override fun onError(baseException: BaseException) {
  }

  private fun updateCurrentOffice(position: Int) {
    currentOffice.set(mListOffice[position].name)
    mBookRequest.officeId = mListOffice[position].id
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

  fun onPickOffice() {
    mListOffice.let {
      val workSpace: MutableList<String> = mutableListOf()
      mListOffice.mapTo(workSpace) { it.name!! }
      mDialogManager.dialogListSingleChoice(getString(R.string.select_office), workSpace,
          currentOfficePosition,
          MaterialDialog.ListCallbackSingleChoice { _, _, position, _ ->
            currentOfficePosition = position
            updateCurrentOffice(currentOfficePosition)
            true
          })
    }

  }
}
