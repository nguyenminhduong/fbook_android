package com.framgia.fbook.data.source.local

import com.framgia.fbook.data.source.TokenDataSource
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsApi
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsKey
import javax.inject.Inject

/**
 * Created by ThS on 8/30/2017.
 */
class TokenLocalDataSource @Inject constructor(
   private val mSharedPrefsApi: SharedPrefsApi) : TokenDataSource.LocalDataSource {

  override fun saveToken(token: String?) {
    mSharedPrefsApi.put(SharedPrefsKey.KEY_TOKEN, token)
  }

  override fun getToken(): String? {
    return mSharedPrefsApi.get(SharedPrefsKey.KEY_TOKEN, String::class.java)
  }
}
