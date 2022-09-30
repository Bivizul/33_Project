package aaa.bivizul.a33project.presentation.betstratwidget

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BetstratButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        elevation = ButtonDefaults.elevation(),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(2.dp, Color.White)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6
        )
    }

}