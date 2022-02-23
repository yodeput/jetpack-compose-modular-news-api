/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.repository


import androidx.annotation.WorkerThread
import com.skydoves.sandwich.*
import com.yodeput.newsapp.common.base.Repository
import com.yodeput.newsapp.common.util.ErrorCode
import com.yodeput.newsapp.common.util.ViewState
import com.yodeput.newsapp.core.dao.NewsDao
import com.yodeput.newsapp.core.database.NewsDb
import com.yodeput.newsapp.core.mapper.ErrorResponseMapper
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.core.network.NewsService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val dao: NewsDao,
    private val api: NewsService,
) : Repository {

    init {
        Timber.d("Injection NewsRepository")
    }

    fun getHeadline(
        isRefresh: Boolean
    ): Flow<ViewState<List<News>>> = flow {
        emit(ViewState.Loading)
        dao.getHeadline().let { dataDb ->
            if (dataDb != null) {
                    if (isRefresh) {
                        fetchHeadline().collect { fetch ->
                            emit(fetch)
                        }
                    } else {
                        emit(ViewState.Success(dataDb.data))
                    }
                }  else {
                fetchHeadline().collect { fetch ->
                    emit(fetch)
                }
            }
        }
    }.flowOn(Dispatchers.IO)


    fun fetchHeadline(): Flow<ViewState<List<News>>> = flow {
        val res = api.headline()
        res.suspendOnSuccess {
            data.articles!!.let {
                emit(ViewState.Success(it))
                dao.insert(
                    NewsDb(
                        id = 1,
                        description = "headline",
                        data = it
                    )
                )
            }
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, message())))
        }
    }.flowOn(Dispatchers.IO)

    fun getBySource(
        isRefresh: Boolean,
        query: Map<String, String>
    ): Flow<ViewState<List<News>>> = flow {
        emit(ViewState.Loading)
        dao.getBySource().let { dataDb ->
            if (dataDb != null) {
                if (isRefresh) {
                    fetchBySource(query).collect { fetch ->
                        emit(fetch)
                    }
                } else {
                    emit(ViewState.Success(dataDb.data))
                }
            } else {
                fetchBySource(query).collect { fetch ->
                    emit(fetch)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    fun fetchBySource(query: Map<String, String>): Flow<ViewState<List<News>>> = flow {
        val res = api.bySource(query = query)
        res.suspendOnSuccess {
            data.articles!!.let {
                emit(ViewState.Success(it))
                dao.insert(
                    NewsDb(
                        id = 2,
                        description = "sources",
                        data = it
                    )
                )
            }
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, message())))
        }
    }.flowOn(Dispatchers.IO)

    fun getByCategory(
        isRefresh: Boolean,
        query: Map<String, String>
    ): Flow<ViewState<List<News>>> = flow {
        emit(ViewState.Loading)
        dao.getByCategories().let { dataDb ->
            if (dataDb != null) {
                if (isRefresh) {
                    fetchByCategory(query).collect { fetch ->
                        emit(fetch)
                    }
                } else {
                    emit(ViewState.Success(dataDb.data))
                }
            } else {
                fetchByCategory(query).collect { fetch ->
                    emit(fetch)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    fun fetchByCategory(query: Map<String, String>): Flow<ViewState<List<News>>> = flow {
        val res = api.bySource(query = query)
        res.suspendOnSuccess {
            data.articles!!.let {
                emit(ViewState.Success(it))
                dao.insert(
                    NewsDb(
                        id = 3,
                        description = "category",
                        data = it
                    )
                )
            }
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, message())))
        }
    }.flowOn(Dispatchers.IO)
}