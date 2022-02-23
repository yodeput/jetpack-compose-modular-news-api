/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.di

import com.yodeput.newsapp.common.base.Repository
import com.yodeput.newsapp.core.dao.NewsDao
import com.yodeput.newsapp.core.network.NewsService
import com.yodeput.newsapp.core.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNewsRepository(newsDao: NewsDao, newsService: NewsService): Repository {
        return NewsRepository(newsDao, newsService)
    }
}