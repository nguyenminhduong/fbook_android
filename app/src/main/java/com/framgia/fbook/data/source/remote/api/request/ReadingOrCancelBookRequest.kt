package com.framgia.fbook.data.source.remote.api.request

import com.framgia.fbook.data.model.ActionBookDetail
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by framgia on 19/09/2017.
 */
class ReadingOrCancelBookRequest : BaseRequest() {
  @Expose
  @SerializedName("item")
  var actionBookDetail: ActionBookDetail? = null
}
