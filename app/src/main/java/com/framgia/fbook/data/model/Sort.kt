package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/22/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class Sort : BaseModel() {

  @SerializedName("by")
  @Expose
  var by: String? = null
  @SerializedName("order_by")
  @Expose
  var orderBy: String? = null
}
