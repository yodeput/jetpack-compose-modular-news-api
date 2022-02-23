/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.component


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.yodeput.newsapp.common.theme.NewsTheme

@Composable
fun DialogConfirm(
    title: String,
    message: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        title = {  Text(text = title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onBackground) },
        text = { Text(text = message, color = MaterialTheme.colorScheme.onBackground) },
        containerColor = MaterialTheme.colorScheme.background,
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Confirm")
            }
        },
        onDismissRequest = onDismiss,
        properties = DialogProperties(
             dismissOnBackPress = false,
            dismissOnClickOutside = false,
        )
    )
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    NewsTheme() {
        DialogConfirm("Title","Dialog Message", {}){}
    }
}
@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    NewsTheme(darkTheme = true) {
        DialogConfirm("Title","Dialog Message", {}){}
    }
}