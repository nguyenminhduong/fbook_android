package com.framgia.fbook.data.source.remote.api.response

import com.framgia.fbook.data.model.Book
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/20/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class BaseBookByCategoryResponse : BaseRespone() {
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
  @SerializedName("category")
  @Expose
  var categoryResponse: CategoryResponse? = null

  inner class CategoryResponse {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("data")
    @Expose
    var data: List<Book>? = null
  }
}
