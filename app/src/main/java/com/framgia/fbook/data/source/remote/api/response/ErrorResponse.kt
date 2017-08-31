package com.framgia.fbook.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by framgia on 11/05/2017.
 */

class ErrorResponse {

  @SerializedName("description")
  @Expose
  var message: List<String>? = null
  @SerializedName("status")
  @Expose
  var status: Boolean? = null
  @SerializedName("code")
  @Expose
  var code: Int? = null


}
