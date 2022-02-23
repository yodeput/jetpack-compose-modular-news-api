/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.QueryBuilder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.feature.list.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemNews(
    item: News,
    onSelected: () -> Unit,
) {

    Box(
        Modifier
            .height(120.dp)
            .fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ) {
            Row(
                modifier = Modifier
                    .clickable(onClick = onSelected)
            ) {
                Box(
                    Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    CoilImage(
                        imageModel = item.urlToImage,
                        contentScale = ContentScale.Crop, // Crop, Fit, Inside, FillHeight, FillWidth, None
                        previewPlaceholder = R.drawable.img_placeholder,
                        placeHolder = painterResource(R.drawable.img_placeholder),
                        error = painterResource(R.drawable.img_placeholder)
                    )
                }

                Column(Modifier.padding(5.dp)) {
                    Text(
                        item.title!!,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        item.source?.name!!,
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                    )
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(3.dp)
                                .align(Alignment.BottomEnd),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.TwoTone.QueryBuilder, null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                item.publishedTime,
                                modifier = Modifier.padding(start = 3.dp),
                                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        ItemNews(
            item = News.mock()
        ) {}
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        ItemNews(
            item = News.mock()
        ) {}
    }
}