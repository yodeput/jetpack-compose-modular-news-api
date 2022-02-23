/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.QueryBuilder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.core.response.ArticleResponse
import com.yodeput.newsapp.feature.list.R

@OptIn(ExperimentalPagerApi::class, androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun HeadlineNews(
    data: List<News>,
    onSelected: (News) -> Unit,
) {
    val pagerState = rememberPagerState()
    Box() {
        HorizontalPager(
            count = data.size,
            state = pagerState,
        ) { page ->
            val item = data[page]
            Card(
                shape = RoundedCornerShape(0.dp),
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
            ) {
                Box(
                    Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .clickable(onClick = { onSelected(item) })
                ) {
                    CoilImage(
                        modifier = Modifier
                            .height(240.dp)
                            .fillMaxWidth()
                            .drawWithContent {
                                val colors = listOf(
                                    Color.Black,
                                    Color.Transparent
                                )
                                drawContent()
                                drawRect(
                                    brush = Brush.verticalGradient(colors),
                                    blendMode = BlendMode.DstIn
                                )
                            },
                        imageModel = item.urlToImage,
                        contentScale = ContentScale.Crop, // Crop, Fit, Inside, FillHeight, FillWidth, None
                        circularReveal = CircularReveal(duration = 250),
                        previewPlaceholder = R.drawable.img_placeholder,
                        placeHolder = painterResource(R.drawable.img_placeholder),
                        error = painterResource(R.drawable.img_placeholder)
                    )
                    Column(
                        Modifier
                            .padding(10.dp)
                            .align(
                                Alignment.BottomCenter
                            )
                    ) {
                        Text(
                            item.title!!,
                            style = MaterialTheme.typography.titleSmall.copy(color = Color.White),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            modifier = Modifier.padding(top = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.TwoTone.QueryBuilder, null,
                                tint = Color.White,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                item.publishedTime,
                                modifier = Modifier.padding(start = 2.dp),
                                style = MaterialTheme.typography.labelSmall.copy(color = Color.White),
                            )
                        }
                    }
                }
            }

        }
        HorizontalPagerIndicator(
            activeColor = MaterialTheme.colorScheme.secondary,
            pagerState = pagerState, modifier = Modifier
                .padding(20.dp)
                .align(
                    Alignment.TopEnd
                )
        )
    }
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            HeadlineNews(
                data = ArticleResponse.mockHeadline().articles!!
            ) {}
        }
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            HeadlineNews(
                data = ArticleResponse.mockHeadline().articles!!
            ) {}
        }

    }
}