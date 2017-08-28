package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class Owner {
  @Expose
  @SerializedName("id")
  var id: Int = 0
  @Expose
  @SerializedName("name")
  var name: String? = null
  @Expose
  @SerializedName("avatar")
  var avatar: String? = null
  @Expose
  @SerializedName("position")
  var position: String? = null
  @Expose
  @SerializedName("pivot")
  var pivot: Pivot? = null

  inner class Pivot {
    @Expose
    @SerializedName("book_id")
    var bookId: Int = 0
    @Expose
    @SerializedName("user_id")
    var userId: Int = 0
    @Expose
    @SerializedName("status")
    var status: String? = null
  }
}
