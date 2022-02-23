/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yodeput.newsapp.core.model.News
import java.util.*

object NewsConverter {
    var gson = Gson()
    @TypeConverter
    fun stringToTransactionList(data: String?): List<News> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<News>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun TransactionListToString(someObjects: List<News>): String? {
        return gson.toJson(someObjects)
    }
}