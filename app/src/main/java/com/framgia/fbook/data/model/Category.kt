package com.framgia.fbook.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by levutantuan on 9/11/17.
 */
class Category() : BaseModel(), Parcelable {

  @SerializedName("id")
  @Expose
  var id: Int? = null
  @SerializedName("name")
  @Expose
  var name: String? = null
  @SerializedName("description")
  @Expose
  var description: String? = null

  constructor(parcel: Parcel) : this() {
    id = parcel.readValue(Int::class.java.classLoader) as? Int
    name = parcel.readString()
    description = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(id)
    parcel.writeString(name)
    parcel.writeString(description)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Category> {
    override fun createFromParcel(parcel: Parcel): Category {
      return Category(parcel)
    }

    override fun newArray(size: Int): Array<Category?> {
      return arrayOfNulls(size)
    }
  }
}
