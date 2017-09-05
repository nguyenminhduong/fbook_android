package com.framgia.fbook.data.source.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/5/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class SearchBookRequest {

  @SerializedName("search")
  @Expose
  var searchBookData: SearchBookData? = null

  class SearchBookData {
    @SerializedName("keyword")
    @Expose
    var keyWord: String? = null
    @Expose
    @SerializedName("field")
    var field: String? = null
  }
}
