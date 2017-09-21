package com.framgia.fbook.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/21/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class SortBook() : BaseModel(), Parcelable {

  @SerializedName("text")
  @Expose
  var text: String? = null
  @SerializedName("field")
  @Expose
  var field: String? = null

  constructor(parcel: Parcel) : this() {
    text = parcel.readString()
    field = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(text)
    parcel.writeString(field)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<SortBook> {
    override fun createFromParcel(parcel: Parcel): SortBook {
      return SortBook(parcel)
    }

    override fun newArray(size: Int): Array<SortBook?> {
      return arrayOfNulls(size)
    }
  }
}
