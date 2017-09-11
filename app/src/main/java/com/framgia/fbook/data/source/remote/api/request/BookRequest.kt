package com.framgia.fbook.data.source.remote.api.request

import com.framgia.fbook.R
import com.framgia.fbook.utils.validator.Rule
import com.framgia.fbook.utils.validator.ValidType
import com.framgia.fbook.utils.validator.Validation
import java.io.File

/**
 * Created by framgia on 07/09/2017.
 */

class BookRequest : BaseRequest() {
  @Validation(
      Rule(types = intArrayOf(ValidType.NON_EMPTY), message = R.string.is_empty)
  )
  var title: String? = ""
  @Validation(
      Rule(types = intArrayOf(ValidType.NON_EMPTY), message = R.string.is_empty)
  )
  var description: String? = ""
  @Validation(
      Rule(types = intArrayOf(ValidType.NON_EMPTY), message = R.string.is_empty)
  )
  var author: String? = ""
  var publishDate: String? = ""
  var categoryId: Int? = null
  var officeId: Int? = null
  var listImage: List<Image> = arrayListOf()

  class Image {
    var image: File? = null
    var type: Int? = 0
  }
}
