package com.framgia.fbook.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ThS on 8/30/2017.
 */
class SignInResponse : BaseRespone() {

  @SerializedName("fauth")
  @Expose
  var signInData: SignInData? = null

  inner class SignInData {
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("refresh_token")
    @Expose
    var refreshToken: String? = null
  }
}
