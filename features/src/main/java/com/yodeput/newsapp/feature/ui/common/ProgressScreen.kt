/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.QueryBuilder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.yodeput.newsapp.core.model.News

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "ProgressScreen")
fun ProgressScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
            shape = RoundedCornerShape(28.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Column(
                modifier = Modifier.padding(40.dp)
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "loadingHeadline")
fun ShimmerHeadline() {
    val item = News.mock()
    Card(
        shape = RoundedCornerShape(0.dp),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
    ) {
        Box(
            Modifier
                .height(240.dp)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .placeholder(
                        visible = true,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White
                        ),
                    ),
            )
            Column(
                Modifier
                    .padding(5.dp)
                    .align(Alignment.BottomStart)) {
                Text(
                    item.title!!,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.placeholder(
                        visible = true,
                        color = MaterialTheme.colorScheme.primary,
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White
                        ),
                    ),
                )
                Row(
                    modifier = Modifier
                        .padding(3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.TwoTone.QueryBuilder, null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        item.publishedTime,
                        modifier = Modifier
                            .padding(start = 3.dp, top = 3.dp)
                            .placeholder(
                                visible = true,
                                color = MaterialTheme.colorScheme.primary,
                                highlight = PlaceholderHighlight.shimmer(
                                    highlightColor = Color.White
                                ),
                            ),
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "LoadingList")
fun ShimmerNews() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(top = 10.dp)
    ) {
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NewsItem() {
    val item = News.mock()
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
            Row {
                Box(
                    Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .placeholder(
                            visible = true,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = Color.White
                            ),
                        ),
                )
                Column(Modifier.padding(5.dp)) {
                    Text(
                        item.title!!,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.placeholder(
                            visible = true,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = Color.White
                            ),
                        ),
                    )
                    Text(
                        item.source?.name!!,
                        modifier = Modifier
                            .padding(top = 3.dp)
                            .placeholder(
                                visible = true,
                                color = MaterialTheme.colorScheme.primaryContainer,
                                highlight = PlaceholderHighlight.shimmer(
                                    highlightColor = Color.White
                                ),
                            ),
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
                                tint = MaterialTheme.colorScheme.primaryContainer,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                item.publishedTime,
                                modifier = Modifier
                                    .padding(start = 3.dp, top = 3.dp)
                                    .placeholder(
                                        visible = true,
                                        color = MaterialTheme.colorScheme.primaryContainer,
                                        highlight = PlaceholderHighlight.shimmer(
                                            highlightColor = Color.White
                                        ),
                                    ),
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
fun LoadingListItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val typography = MaterialTheme.typography
        ConstraintLayout(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (column, text1) = createRefs()
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .wrapContentWidth()
                    .constrainAs(column) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Text(
                    modifier = Modifier.placeholder(
                        visible = true,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp),
                    ),
                    text = "Yogi Dewansyah Putra",
                    style = typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .placeholder(
                            visible = true,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = Color.White
                            ),
                            shape = RoundedCornerShape(4.dp),
                        ),
                    text = "123-345-7890",
                    style = typography.labelSmall
                )
            }

            Text(
                modifier = Modifier
                    .constrainAs(text1) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.bottom)
                        bottom.linkTo(parent.top)
                    }
                    .placeholder(
                        visible = true,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp),
                    ),
                text = "$1,1000,0",
                style = typography.titleSmall
            )
        }
    }
}