package com.framgia.fbook.data.source.remote.api.response

import com.framgia.fbook.data.model.Message
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/29/2017.
 */

class BaseResponse<T> {
  @Expose
  @SerializedName("messages")
  var messages: Message? = null
  @Expose
  @SerializedName("items")
  var items: T? = null
}
