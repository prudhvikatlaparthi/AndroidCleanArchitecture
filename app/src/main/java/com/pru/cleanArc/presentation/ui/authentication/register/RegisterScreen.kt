package com.pru.cleanArc.presentation.ui.authentication.register

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
import com.pru.cleanArc.utils.MyPreferences
import com.pru.cleanArc.utils.ScreenRoute

@ExperimentalMaterialApi
@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = hiltViewModel(),
    myPreferences: MyPreferences
) {
    val focusManager = LocalFocusManager.current
    val registrationState = registerViewModel.state.value
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = {
            MyAppBar(backButton = {
                navController.popBackStack()
            }, title = "Sign up")
        }) {
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sign up with one of following options.", fontSize = 18.sp)
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
                        title = "Name",
                        textController = registerViewModel.nameTextController,
                        hint = "ex: Jack",
                        onValueChange = { text ->
                            registerViewModel.updateName(text = text)
                        },
                        onClear = { registerViewModel.updateName(text = "") },
                        keyboardActionsDone = { focusManager.clearFocus() })
                    Spacer(modifier = Modifier.height(20.dp))
                    MyEditText(
                        title = "Email",
                        textController = registerViewModel.emailTextController,
                        hint = "ex : jack@mail.com",
                        onValueChange = { text ->
                            registerViewModel.updateEmail(text = text)
                        },
                        onClear = { registerViewModel.updateEmail(text = "") },
                        keyboardActionsDone = { focusManager.clearFocus() })
                    Spacer(modifier = Modifier.height(20.dp))
                    MyEditText(
                        title = "Password",
                        textController = registerViewModel.passwordTextController,
                        hint = "Pick a strong password",
                        onValueChange = { text ->
                            registerViewModel.updatePassword(text = text)
                        },
                        onClear = { registerViewModel.updatePassword(text = "") },
                        isPassword = true,
                        keyboardActionsDone = { focusManager.clearFocus() }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (registrationState.error.isNotBlank()) {
                        ErrorView(msg = registrationState.error)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    GradientButton(
                        text = "Create Account",
                    ) {
                        registerViewModel.registerUser()
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Log in")
                        }
                    }, textAlign = TextAlign.Center, modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                }
                if (registrationState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                if (registrationState.userID > Int.MIN_VALUE) {
                    LaunchedEffect(key1 = Unit) {
                        navController.navigate(ScreenRoute.HomeScreen.route) {
                            popUpTo(ScreenRoute.LoginScreen.route) { inclusive = true }
                        }
                    }
                }
            }

        }
    }
}

