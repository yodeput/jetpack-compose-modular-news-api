/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.splash

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class SplashViewmodel @Inject
constructor(application: Application) : ViewModel() {

    private val context: Context = application.applicationContext
    val _packageInfo = MutableStateFlow(PackageInfo())
    val packageInfo: StateFlow<PackageInfo>
        get() = _packageInfo

    init {
        getAppVersion()
    }

    fun getAppVersion() {
        viewModelScope.launch {

            val pInfo = context.packageManager.getPackageInfo(
                context.packageName, 0
            )
            //val version = pInfo.versionName
            //val verCode = pInfo.versionCode
            _packageInfo.tryEmit(pInfo);
        }
    }

}