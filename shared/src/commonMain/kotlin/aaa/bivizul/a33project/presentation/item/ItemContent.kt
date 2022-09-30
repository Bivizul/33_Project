package aaa.bivizul.a33project.presentation.item

import aaa.bivizul.a33project.domain.model.Betstratin
import aaa.bivizul.a33project.presentation.betstratwidget.Betstratcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val betstratItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val scrollState = rememberScrollState()

    if (betstratItemList != null) {
        betstratItemList?.let { list ->
            list[model.selectedBetstratItemId - 1].let { item ->
                val betstratinList = item.betstratin
                Column(
                    modifier = modifier
                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.betstrattitle,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = item.betstratdesc,
                        style = MaterialTheme.typography.body1
                    )
                    if (betstratinList != emptyList<Betstratin>()) {
                        for (i in betstratinList) {
                            Text(
                                text = i.betstratsubtitle,
                                style = MaterialTheme.typography.h6
                            )
                            Text(
                                text = i.betstratsubdesc,
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                }
            }
        }
    } else {
        Betstratcp(modifier = modifier)
    }
}