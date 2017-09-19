package com.framgia.fbook.data.source.remote.api.request

import com.framgia.fbook.data.model.ReadingBook
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by framgia on 19/09/2017.
 */
class ReadingBookRequest : BaseRequest() {
  @Expose
  @SerializedName("item")
  var readingBook: ReadingBook? = null
}
