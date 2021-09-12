package com.pru.cleanArc.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pru.cleanArc.R

@Composable
fun MyAppBar(backButton: (() -> Unit)? = null, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f), verticalAlignment = Alignment.CenterVertically
    ) {
        if (backButton != null) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
                    .size(24.dp)
                    .clickable {
                        backButton.invoke()
                    },
                tint = MaterialTheme.colors.onBackground
            )
        }
        Text(
            text = title,
            modifier = Modifier.padding(start = if (backButton == null) 16.dp else 8.dp),
            style = MaterialTheme.typography.h3
        )
    }
}