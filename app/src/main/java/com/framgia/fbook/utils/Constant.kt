package com.framgia.fbook.utils

/**
 * Created by le.quang.dao on 10/03/2017.
 */

object Constant {

  val END_POINT_URL = "http://api-book.framgia.vn"

  val BREAK_LINE = "\n"
  val LIST_BOOK_EXTRA = "LIST_BOOK_EXTRA"
  val LATE = "latest"
  val VIEW = "view"
  val RATING = "rating"
  val WAITING = "waiting"
  val READ = "read"
  val PAGE = 1

  val BOOK_DETAIL_EXTRA = "book_detail"

  object Tab {
    val TAB_HOME: Int = 0
    val TAB_MY_BOOK: Int = 1
    val TAB_NOTIFICATION: Int = 2
    val TAB_ACCOUNT: Int = 3
  }

  object RequestCode {
    val TAB_MY_BOOK_REQUEST: Int = 101;
    val TAB_PROFILE_REQUEST: Int = 102;
  }
}
