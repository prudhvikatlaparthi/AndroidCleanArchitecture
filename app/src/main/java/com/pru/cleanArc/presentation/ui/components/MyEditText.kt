package com.pru.cleanArc.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pru.cleanArc.presentation.theme.BorderBackground
import com.pru.cleanArc.presentation.theme.HintColor
import com.pru.cleanArc.presentation.theme.LiteBackground

@Composable
fun MyEditText(
    textController: State<String>,
    title: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    isPassword: Boolean = false,
    keyboardActionsDone: (KeyboardActionScope.() -> Unit),
) {
    Column {
        Text(text = title)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = BorderBackground,
                    shape = RoundedCornerShape(8.dp)
                ),
            value = textController.value,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LiteBackground,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = onValueChange,
            singleLine = true,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.h5.copy(fontSize = 16.sp, color = HintColor)
                )
            },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (textController.value.isNotEmpty()) {
                    IconButton(onClick = onClear) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            },
            keyboardActions = KeyboardActions(onDone = keyboardActionsDone),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
        )
    }
}