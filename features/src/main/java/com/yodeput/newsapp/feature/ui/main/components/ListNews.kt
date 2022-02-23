/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.core.response.ArticleResponse

@Composable
fun ListNews(
    data: List<News>,
    onSelected: (News) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(top = 5.dp)
    ) {
        items(
            items = data,
            itemContent = {
                ItemNews(item = it) { onSelected(it) }
            }
        )
    }
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            ListNews(
                data = ArticleResponse.mock().articles!!
            ) {}
        }
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            ListNews(
                data = ArticleResponse.mock().articles!!
            ) {}
        }

    }
}