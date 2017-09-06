package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class Book() {

  @Expose
  @SerializedName("id")
  var id: Int? = null
  @Expose
  @SerializedName("title")
  var title: String? = null
  @Expose
  @SerializedName("description")
  var description: String? = null
  @Expose
  @SerializedName("author")
  var author: String? = null
  @Expose
  @SerializedName("publish_date")
  var publishDate: String? = null
  @Expose
  @SerializedName("total_page")
  var totalPage: Int? = null
  @Expose
  @SerializedName("count_view")
  var countView: Int? = null
  @Expose
  @SerializedName("avg_star")
  var avgStar: Float? = null
  @Expose
  @SerializedName("overview")
  var overview: String? = null
  @Expose
  @SerializedName("image")
  var image: Image? = null
  @Expose
  @SerializedName("owners")
  var owners: List<Owner>? = arrayListOf()
}
