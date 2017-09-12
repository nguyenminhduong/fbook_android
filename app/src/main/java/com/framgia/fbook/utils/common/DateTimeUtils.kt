package com.framgia.fbook.utils.common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by framgia on 12/09/2017.
 */

object DateTimeUtils {
  fun getDateStringFromDayMonthYear(year: Int, month: Int, day: Int, format: String): String? {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_MONTH, day)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.YEAR, year)
    return convertDateToString(calendar.time, format)
  }

  fun convertDateToString(source: Date?, format: String): String? {
    if (source == null) {
      return null
    }
    val df = SimpleDateFormat(format, Locale.US)
    return df.format(source)
  }
}
