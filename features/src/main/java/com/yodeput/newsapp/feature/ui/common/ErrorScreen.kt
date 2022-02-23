/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.feature.list.R

@Composable
fun ErrorScreen(message: String, onRefresh: (() -> Unit)?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            message,
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground)
        )
        Spacer(Modifier.height(16.dp))
        if (onRefresh != null) {
            Button(onClick = onRefresh) {
                Text(
                    text = stringResource(id = R.string.bt_retry),
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary))
            }
        }
    }
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        ErrorScreen("Error message") {}
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        ErrorScreen("Error message") {}
    }
}