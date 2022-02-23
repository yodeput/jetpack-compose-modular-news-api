/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.network

import com.skydoves.sandwich.ApiResponse
import com.yodeput.newsapp.core.response.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun headline(
        @Query("country") country: String = "us",
        @Query("languange") languange: String = "en",
        @Query("sortBy") sortBy: String = "publishedAt",
    ): ApiResponse<ArticleResponse>

    @GET("/v2/top-headlines")
    suspend fun bySource(@QueryMap(encoded=true) query: Map<String, String>): ApiResponse<ArticleResponse>
}