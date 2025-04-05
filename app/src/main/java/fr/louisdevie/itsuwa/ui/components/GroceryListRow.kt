package fr.louisdevie.itsuwa.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.louisdevie.itsuwa.R
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme


@Composable
fun GroceryListRow(label: String, onDone: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.weight(1f))
        IconButton(onClick = onDone, modifier = Modifier.size(56.dp)) {
            Icon(
                Icons.Filled.Check,
                contentDescription = stringResource(id = R.string.action_done)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GroceryListRowPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        GroceryListRow("Item") {}
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryListRowPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        GroceryListRow("Item") {}
    }
}
