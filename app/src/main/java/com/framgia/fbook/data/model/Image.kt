package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class Image() {
  @Expose
  @SerializedName("path")
  var path: String? = null
  @Expose
  @SerializedName("size")
  var size: Int = 0
  @Expose
  @SerializedName("mobile")
  var mobileImage: MobileImage? = null

  inner class MobileImage {
    @Expose
    @SerializedName("thumbnail_path")
    var thumbnailPath: String? = null
    @Expose
    @SerializedName("small_path")
    var smallPath: String? = null
    @Expose
    @SerializedName("medium_path")
    var mediumPath: String? = null
    @Expose
    @SerializedName("large_path")
    var largePath: String? = null
  }
}
