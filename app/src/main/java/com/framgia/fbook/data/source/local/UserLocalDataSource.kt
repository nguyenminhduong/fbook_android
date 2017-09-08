package com.framgia.fbook.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.framgia.fbook.data.model.User
import com.framgia.fbook.data.source.UserDataSource
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsApi
import com.framgia.fbook.data.source.local.sharedprf.SharedPrefsKey
import com.framgia.fbook.data.source.local.sqlite.UserDbHelper
import com.framgia.fbook.utils.common.StringUtils
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Created by le.quang.dao on 10/03/2017.
 */

class UserLocalDataSource @Inject
constructor(context: Context,
    private val mSharedPrefsApi: SharedPrefsApi) : UserDataSource.LocalDataSource {

  private val mDbHelper: UserDbHelper = UserDbHelper(context)
  private lateinit var mDatabase: SQLiteDatabase

  override fun saveUser(user: User?) {
    val data = Gson().toJson(user)
    mSharedPrefsApi.put(SharedPrefsKey.KEY_USER, data)
  }

  override fun getUserLocal(): User? {
    val data = mSharedPrefsApi[SharedPrefsKey.KEY_USER, String::class.java]
    return if (StringUtils.isBlank(data)) {
      null
    } else {
      Gson().fromJson(data, User::class.java)
    }
  }

  override fun clearData() {
    mSharedPrefsApi.clear()
  }
}
