/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Source(
    @Json(name = "category") val category: String? = null,
    @Json(name = "country") val country: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "id") val id: String? = null,
    @Json(name = "language") val language: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "url") val url: String? = null
) : Parcelable {
    companion object {
        fun mock() = Source(
            id = "engadget",
            name = "Engadget",
            description = "Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics.",
            url = "https://www.engadget.com",
            category = "technology",
            language = "en",
            country = "us"
        )
    }
}