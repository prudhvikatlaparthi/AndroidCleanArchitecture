package com.pru.cleanArc.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pru.cleanArc.presentation.theme.CryptocurrencyAppYTTheme
import com.pru.cleanArc.presentation.ui.authentication.login.LoginScreen
import com.pru.cleanArc.presentation.ui.authentication.register.RegisterScreen
import com.pru.cleanArc.presentation.ui.home.HomeScreen
import com.pru.cleanArc.utils.MyPreferences
import com.pru.cleanArc.utils.ScreenRoute
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var myPreferences: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.LoginScreen.route
                    ) {
                        composable(ScreenRoute.LoginScreen.route) {
                            LoginScreen(
                                navController = navController,
                                myPreferences = myPreferences
                            )
                        }
                        composable(ScreenRoute.RegisterScreen.route) {
                            RegisterScreen(
                                navController = navController,
                                myPreferences = myPreferences
                            )
                        }
                        composable(ScreenRoute.HomeScreen.route) {
                            HomeScreen(navController = navController, myPreferences = myPreferences)
                        }
                    }
                }
            }
        }
    }
}