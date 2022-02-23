/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.yodeput.newsapp.common.theme.NewsTheme
import com.yodeput.newsapp.feature.base.BaseFragment
import com.yodeput.newsapp.feature.list.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashFragment : BaseFragment() {
    private val viewModel: SplashViewmodel by viewModels()

    @Composable
    override fun setContent() {
      val pm = viewModel.packageInfo.collectAsState().value

        SplashScreen(
            timer = 1000L,
            version = pm.versionName,
        )
    }


    @Composable
    fun SplashScreen(
        timer: Long,
        version: String,
    ) {
        delayFunction(timer = timer, nav = com.yodeput.newsapp.feature.ui.splash.SplashFragmentDirections.actionSplashToMain())

        Box( modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)) {

            Text(
                text = stringResource(id = R.string.app).uppercase(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 40.dp),
                style = MaterialTheme.typography.displayLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 60.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(
                        Alignment.BottomCenter
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.onPrimary

                )
                Spacer(Modifier.size(16.dp))
                Spacer(Modifier.size(16.dp))
                Spacer(Modifier.size(16.dp))
                Text(version, color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier)
                Spacer(Modifier.size(16.dp))
                Spacer(Modifier.size(16.dp))
            }
        }
    }

    @Composable
    fun delayFunction (
        timer: Long,
        nav: NavDirections
    ) {
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            delay(timer)
            findNavController().navigate(nav)
        }
    }

    @Composable
    @Preview(name = " Light")
    private fun PreviewLight() {
        NewsTheme() {
            SplashScreen(
                timer = 1000L,
                version = "1.0.0",
            )
        }
    }
    @Composable
    @Preview(name = " Dark")
    private fun PreviewDark() {
        NewsTheme(darkTheme = true) {
            SplashScreen(
                timer = 1000L,
                version = "1.0.0",
            )
        }
    }
}