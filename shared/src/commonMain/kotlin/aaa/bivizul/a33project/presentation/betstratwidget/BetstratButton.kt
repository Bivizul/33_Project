package aaa.bivizul.a33project.presentation.betstratwidget

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BetstratButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6
        )
    }

}