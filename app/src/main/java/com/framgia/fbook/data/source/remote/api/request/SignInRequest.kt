package com.framgia.fbook.data.source.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ThS on 8/30/2017.
 */
class SignInRequest : BaseRequest() {
  @Expose
  @SerializedName("email")
  var email: String? = null
  @Expose
  @SerializedName("password")
  var password: String? = null
  @SerializedName("refresh_token")
  @Expose
  var refreshToken: String? = null
}
