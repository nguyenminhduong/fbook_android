package com.framgia.fbook.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/5/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class BaseBookRespone<T> : BaseRespone() {
  @SerializedName("total")
  @Expose
  var total: Int? = null
  @SerializedName("per_page")
  @Expose
  var perPage: Int? = null
  @SerializedName("current_page")
  @Expose
  var currentPage: Int? = null
  @SerializedName("next_page")
  @Expose
  var nextPage: Int? = null
  @SerializedName("prev_page")
  @Expose
  var prevPage: Int? = null
  @SerializedName("data")
  @Expose
  var data: T? = null
}
