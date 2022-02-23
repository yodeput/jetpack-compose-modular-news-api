/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yodeput.newsapp.core.model.News

@Entity(tableName = "news")
class NewsDb(
    @PrimaryKey val id: Long,
    val description: String,
    val data: List<News>,
)

