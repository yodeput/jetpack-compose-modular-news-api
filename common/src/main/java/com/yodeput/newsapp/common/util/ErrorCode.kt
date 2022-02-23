/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.common.util

/**
 * A customized pokemon error response.
 *
 * @param code A network response code.
 * @param message A network error message.
 */
data class ErrorCode(
  val code: Int,
  val message: String?
) {
  override fun toString(): String {
    return "ErrorCode ===> (code=$code, message=$message)"
  }
}
