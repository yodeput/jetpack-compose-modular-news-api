/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.navArgs
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.yodeput.newsapp.feature.base.BaseFragment

class DetailFragment : BaseFragment() {

    @SuppressLint("SetJavaScriptEnabled")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun setContent() {
        val args: DetailFragmentArgs by navArgs()
        val state = rememberWebViewState(args.news.url!!)
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colorScheme.primary,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { goBack() }) {
                            Icon(
                                imageVector = Icons.TwoTone.ArrowBack,
                                contentDescription = "Back Button",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        Text(
                            args.news.title!!,
                            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, args.news.url!!)
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)
                }) {
                    Icon(
                        imageVector = Icons.TwoTone.Share,
                        contentDescription = "Share Button",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        ) {
            Column {
                if (state.isLoading) LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    trackColor = MaterialTheme.colorScheme.primaryContainer
                )
                WebView(
                    state = state,
                    onCreated = { it.settings.javaScriptEnabled = true }
                )
            }

        }
    }
}