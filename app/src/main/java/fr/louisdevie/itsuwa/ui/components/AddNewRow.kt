package fr.louisdevie.itsuwa.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.louisdevie.itsuwa.R
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme


@Composable
fun AddNewRow(onAdd: (String) -> Unit) {
    val (input, setInput) = remember { mutableStateOf("") }

    val doAdd = {
        val trimmedInput = input.trim()
        if (trimmedInput.isNotEmpty()) {
            onAdd(trimmedInput)
            setInput("")
        }
    }

    Row {
        TextField(
            input,
            setInput,
            placeholder = { Text(stringResource(id = R.string.prompt_add_item)) },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent
            ),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = doAdd, modifier = Modifier.size(56.dp)) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.action_add)
                    )
                }
            },
            keyboardActions = KeyboardActions { doAdd() }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AddNewRowPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        AddNewRow(onAdd = { })
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun AddNewRowPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        AddNewRow(onAdd = { })
    }
}
