package aaa.bivizul.a33project.presentation.main

import aaa.bivizul.a33project.domain.util.Betstratcon.BETSTRATAN
import aaa.bivizul.a33project.presentation.betstratwidget.BetstratButton
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: MainModel,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = BETSTRATAN,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BetstratButton(
                onClick = { component.onClickListModel() },
                text = "List"
            )
            BetstratButton(
                onClick = { component.onClickSettingsModel() },
                text = "Settings"
            )
        }

    }

}