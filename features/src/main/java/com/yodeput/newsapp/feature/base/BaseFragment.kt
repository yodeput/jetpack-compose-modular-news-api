/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.common.util.composeView
import com.yodeput.newsapp.feature.ui.common.ErrorScreen
import com.yodeput.newsapp.feature.ui.component.DialogMessage

abstract class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {

        NewsTheme {
            setContent()
        }
    }

    @Composable
    abstract fun setContent(): Unit

    @Composable
    open fun showDialog(isShow: Boolean, title:String, message: String, onDismiss: () -> Unit){
        if(isShow) {
            DialogMessage(
                title = title,
                message = message,
                onDismiss = {
                    onDismiss()
                })
        }
    }

    @Composable
    open fun showToast(message: String, duration: Int ){
        Toast.makeText(
            context,
            message,
            duration
        ).show()
    }

    @Composable
    open fun showError(isShow: Boolean, title:String, message: String, onRefresh: () -> Unit){
        if(isShow) {
            ErrorScreen(
                message = message,
                onRefresh = {
                    onRefresh()
                })
        }
    }

    fun goToScreen(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    fun goBack() {
        findNavController().navigateUp()
    }
}