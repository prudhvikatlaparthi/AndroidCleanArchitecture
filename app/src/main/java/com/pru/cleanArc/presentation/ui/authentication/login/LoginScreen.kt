package com.pru.cleanArc.presentation.ui.authentication.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pru.cleanArc.presentation.ui.components.*
import com.pru.cleanArc.utils.AndroidHelper.showToast
import com.pru.cleanArc.utils.MyPreferences
import com.pru.cleanArc.utils.ScreenRoute

@ExperimentalMaterialApi
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    myPreferences: MyPreferences
) {
    val focusManager = LocalFocusManager.current
    val loginState = loginViewModel.state.value
    Surface(color = MaterialTheme.colors.background) {
        if (myPreferences.getLoginUserID() > Int.MIN_VALUE) {
            NavigateToHomeScreen(navController = navController)
            return@Surface
        }
        Scaffold(topBar = {
            MyAppBar(title = "Log in")
        }) {
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Log in with one of following options.", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SocialLoginCardView(modifier = Modifier.weight(0.5f), title = "G") {

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        SocialLoginCardView(modifier = Modifier.weight(0.5f), title = "F") {

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    MyEditText(
                        title = "Email",
                        textController = loginViewModel.emailTextController,
                        hint = "ex : jack@mail.com",
                        onValueChange = { text ->
                            loginViewModel.updateEmail(text = text)
                        },
                        onClear = { loginViewModel.updateEmail(text = "") },
                        keyboardActionsDone = { focusManager.clearFocus() })
                    Spacer(modifier = Modifier.height(20.dp))
                    MyEditText(
                        title = "Password",
                        textController = loginViewModel.passwordTextController,
                        hint = "Pick a strong password",
                        onValueChange = { text ->
                            loginViewModel.updatePassword(text = text)
                        },
                        onClear = { loginViewModel.updatePassword(text = "") },
                        isPassword = true,
                        keyboardActionsDone = { focusManager.clearFocus() }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (loginState.error.isNotBlank()) {
                        ErrorView(msg = loginState.error)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    GradientButton(
                        text = "Log in",
                    ) {
                        loginViewModel.loginUser()
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(buildAnnotatedString {
                        append("Don't have an account? ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Sign up")
                        }
                    }, textAlign = TextAlign.Center, modifier = Modifier.clickable {
                        navController.navigate(ScreenRoute.RegisterScreen.route)
                    })
                }
                if (loginState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                if (loginState.userID > Int.MIN_VALUE) {
                    NavigateToHomeScreen(navController)
                }
            }
        }
    }
}

@Composable
private fun NavigateToHomeScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        navController.navigate(ScreenRoute.HomeScreen.route) {
            popUpTo(ScreenRoute.LoginScreen.route) { inclusive = true }
        }
    }
}