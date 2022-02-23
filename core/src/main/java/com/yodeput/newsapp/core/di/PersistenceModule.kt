/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.di

import android.content.Context
import androidx.room.Room
import com.yodeput.newsapp.core.BuildConfig
import com.yodeput.newsapp.core.dao.NewsDao
import com.yodeput.newsapp.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(db: AppDatabase): NewsDao {
        return db.newsDao()
    }
}
