package com.framgia.fbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hyperion on 9/7/2017.
 * Contact me thuanpx1710@gmail.com.
 * Thank you !
 */
class GoogleBook : BaseModel() {
  @SerializedName("id")
  @Expose
  var id: String? = null
  @SerializedName("volumeInfo")
  @Expose
  var volumeInfo: VolumeInfo? = null
  @SerializedName("publisher")
  @Expose
  var publisher: String? = null
  @SerializedName("publishedDate")
  @Expose
  var publishedDate: Int? = null
  @SerializedName("description")
  @Expose
  var description: String? = null
  @SerializedName("readingModes")
  @Expose
  var readingModes: ReadingModes? = null
  @SerializedName("pageCount")
  @Expose
  var pageCount: Int? = null
  @SerializedName("categories")
  @Expose
  var categoriesList: List<String>? = null
  @SerializedName("maturityRating")
  @Expose
  var maturityRating: String? = null
  @SerializedName("imageLinks")
  @Expose
  var imageLink: ImageLink? = null
  @SerializedName("language")
  @Expose
  var language: String? = null
  @SerializedName("previewLink")
  @Expose
  var previewLink: String? = null
  @SerializedName("infoLink")
  @Expose
  var infoLink: String? = null
  @SerializedName("canonicalVolumeLink")
  @Expose
  var canonicalVolumeLink: String? = null

  inner class VolumeInfo : BaseModel() {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("subtitle")
    @Expose
    var subtitle: String? = null
    @SerializedName("authors")
    @Expose
    var listAuthor: List<String>? = null
  }

  inner class ReadingModes : BaseModel() {
    @SerializedName("text")
    @Expose
    var isText: Boolean? = null
    @SerializedName("image")
    @Expose
    var isImage: Boolean? = null

  }

  inner class ImageLink : BaseModel() {
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null
  }
}
