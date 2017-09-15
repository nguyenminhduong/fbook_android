package com.framgia.fbook.screen.addCategoryFavorite;

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.util.Log
import com.framgia.fbook.MainApplication
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Category
import com.framgia.fbook.data.source.CategoryRepository
import com.framgia.fbook.data.source.UserRepository
import com.framgia.fbook.data.source.remote.api.error.BaseException
import com.framgia.fbook.databinding.ActivityAddCategoryFavoriteBinding
import com.framgia.fbook.screen.BaseActivity
import com.framgia.fbook.utils.navigator.Navigator
import com.fstyle.structure_android.widget.dialog.DialogManager
import javax.inject.Inject

/**
 * AddCategoryFavorite Screen.
 */
class AddCategoryFavoriteActivity : BaseActivity(), AddCategoryFavoriteContract.ViewModel {

  @Inject
  internal lateinit var mPresenter: AddCategoryFavoriteContract.Presenter
  @Inject
  internal lateinit var mAdapter: AddCategoryFavoriteAdapter
  @Inject
  internal lateinit var mNavigator: Navigator
  @Inject
  internal lateinit var mUserRepository: UserRepository
  @Inject
  internal lateinit var mCategoryRepository: CategoryRepository
  @Inject
  internal lateinit var mDialogManager: DialogManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerAddCategoryFavoriteComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .addCategoryFavoriteModule(AddCategoryFavoriteModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityAddCategoryFavoriteBinding>(this,
        R.layout.activity_add_category_favorite)
    binding.viewModel = this
    mPresenter.getCategory()
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

  override fun onShowProgressDialog() {
    mDialogManager.showIndeterminateProgressDialog()
  }

  override fun onDismissProgressDialog() {
    mDialogManager.dismissProgressDialog()
  }

  override fun onError(exception: BaseException) {
    Log.e(TAG, exception.getMessageError())
  }

  override fun onGetCategorySuccess(category: List<Category>?) {
    category?.let { mAdapter.updateData(category) }
  }


  fun onClickUpdate() {
    //Todo
  }

  companion object {
    val TAG: String = AddCategoryFavoriteActivity::class.java.name

    fun newInstance(): AddCategoryFavoriteActivity {
      return AddCategoryFavoriteActivity()
    }
  }
}
