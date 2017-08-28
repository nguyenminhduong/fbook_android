package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class Message {
  @Expose
  @SerializedName("code")
  var code: Int = 0
  @Expose
  @SerializedName("status")
  var status: String? = null
}
