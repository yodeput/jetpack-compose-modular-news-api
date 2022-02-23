/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.feature.list.R

@Composable
fun Topbar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.primary,
        title = {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    stringResource(id = R.string.app),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    )
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        Topbar()
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        Topbar()
    }
}