package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class BookType {
  @Expose
  @SerializedName("key")
  var key: String? = null
  @Expose
  @SerializedName("title")
  var title: String? = null
  @Expose
  @SerializedName("data")
  var bookList: List<Book>? = arrayListOf()
}
