package com.framgia.fbook.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenhuy95dn on 8/28/2017.
 */

class Book() : BaseModel(), Parcelable {

  @Expose
  @SerializedName("id")
  var id: Int? = null
  @Expose
  @SerializedName("title")
  var title: String? = null
  @Expose
  @SerializedName("description")
  var description: String? = null
  @Expose
  @SerializedName("author")
  var author: String? = null
  @Expose
  @SerializedName("publish_date")
  var publishDate: String? = null
  @Expose
  @SerializedName("total_page")
  var totalPage: Int? = null
  @Expose
  @SerializedName("count_view")
  var countView: Int? = null
  @Expose
  @SerializedName("avg_star")
  var avgStar: Float? = null
  @Expose
  @SerializedName("overview")
  var overview: String? = null
  @Expose
  @SerializedName("image")
  var image: Image? = null
  @Expose
  @SerializedName("owners")
  var owners: List<Owner>? = arrayListOf()
  @Expose
  @SerializedName("media")
  var images: List<Image>? = arrayListOf()
  @Expose
  @SerializedName("users_waiting")
  var usersWaitings: List<User>? = arrayListOf()
  @Expose
  @SerializedName("users_reading")
  var usersReadings: List<User>? = arrayListOf()
  @Expose
  @SerializedName("users_returning")
  var usersReturnings: List<User>? = arrayListOf()
  @Expose
  @SerializedName("users_returned")
  var usersReturneds: List<User>? = arrayListOf()
  @Expose
  @SerializedName("reviews_detail")
  var reviewDetails: List<ReviewDetail>? = arrayListOf()

  inner class ReviewDetail {
    @Expose
    @SerializedName("id")
    var id: Int? = null
    @Expose
    @SerializedName("content")
    var content: String? = null
    @Expose
    @SerializedName("star")
    var star: Float? = null
    @Expose
    @SerializedName("created_at")
    var createdAt: String? = null
    @Expose
    @SerializedName("user")
    var user: User? = null
  }

  constructor(parcel: Parcel) : this() {
    id = parcel.readValue(Int::class.java.classLoader) as? Int
    title = parcel.readString()
    description = parcel.readString()
    author = parcel.readString()
    publishDate = parcel.readString()
    totalPage = parcel.readValue(Int::class.java.classLoader) as? Int
    countView = parcel.readValue(Int::class.java.classLoader) as? Int
    avgStar = parcel.readValue(Float::class.java.classLoader) as? Float
    overview = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(id)
    parcel.writeString(title)
    parcel.writeString(description)
    parcel.writeString(author)
    parcel.writeString(publishDate)
    parcel.writeValue(totalPage)
    parcel.writeValue(countView)
    parcel.writeValue(avgStar)
    parcel.writeString(overview)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Book> {
    override fun createFromParcel(parcel: Parcel): Book {
      return Book(parcel)
    }

    override fun newArray(size: Int): Array<Book?> {
      return arrayOfNulls(size)
    }
  }
}
