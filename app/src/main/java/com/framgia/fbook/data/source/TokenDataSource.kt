package com.framgia.fbook.data.source

/**
 * Created by ThS on 8/30/2017.
 */
interface TokenDataSource {
  interface LocalDataSource {
    fun saveToken(token: String?)

    fun getToken(): String?
  }
}
