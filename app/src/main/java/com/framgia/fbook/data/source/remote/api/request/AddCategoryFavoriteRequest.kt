package com.framgia.fbook.data.source.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by levutantuan on 9/20/17.
 */
class AddCategoryFavoriteRequest : BaseRequest() {
  @Expose
  @SerializedName("item")
  var item: Tags? = null

  class Tags {
    @Expose
    @SerializedName("tags")
    var tags: String? = null
  }
}
