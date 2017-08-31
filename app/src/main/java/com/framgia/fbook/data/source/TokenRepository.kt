package com.framgia.fbook.data.source

import com.framgia.fbook.data.source.local.TokenLocalDataSource
import javax.inject.Inject

/**
 * Created by ThS on 8/30/2017.
 */
interface TokenRepository : TokenDataSource.LocalDataSource

open class TokenRepositoryImpl @Inject constructor(
    val tokenLocalDataSource: TokenLocalDataSource) : TokenRepository {

  override fun saveToken(token: String) {
    tokenLocalDataSource.saveToken(token)
  }

  override fun getToken(): String? {
    return tokenLocalDataSource.getToken()
  }
}
