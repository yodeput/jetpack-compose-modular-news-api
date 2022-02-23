/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yodeput.newsapp.core.BuildConfig
import com.yodeput.newsapp.core.dao.NewsDao

@Database(
    entities = [NewsDb::class],
    version = BuildConfig.DATABASE_VERSION,
    exportSchema = BuildConfig.DATABASE_EXPORT_SCHEMA
)
@TypeConverters(NewsConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}