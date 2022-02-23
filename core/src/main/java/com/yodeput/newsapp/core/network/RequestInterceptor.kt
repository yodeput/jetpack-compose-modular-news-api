/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.network

import android.content.Context
import com.yodeput.newsapp.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
        val response = originalRequest.newBuilder().url(url).build()
        return chain.proceed(response)
    }
}