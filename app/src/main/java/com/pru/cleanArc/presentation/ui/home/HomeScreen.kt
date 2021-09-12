package com.pru.cleanArc.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pru.cleanArc.R
import com.pru.cleanArc.presentation.ui.components.MyAppBar
import com.pru.cleanArc.utils.MyPreferences

@Composable
fun HomeScreen(navController: NavController, myPreferences: MyPreferences) {
    Scaffold(
        topBar = {
            MyAppBar(title = "Hai there.")
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Home Screen ${myPreferences.getLoginUserID()}")
                Icon(painter = painterResource(id = R.drawable.ic_log_out), contentDescription = "")
            }
        }
    }
}