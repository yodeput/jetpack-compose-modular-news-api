/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yodeput.newsapp.core.database.NewsDb
@Dao
interface NewsDao {
    @Query("SELECT * FROM 'news' WHERE id = 1")
    suspend fun getHeadline(): NewsDb?

    @Query("SELECT * FROM 'news' WHERE id = 2")
    suspend fun getBySource(): NewsDb?

    @Query("SELECT * FROM 'news' WHERE id = 3")
    suspend fun getByCategories(): NewsDb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: NewsDb)

    @Query("DELETE FROM 'news'")
    suspend fun clear()
}