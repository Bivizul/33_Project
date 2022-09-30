package aaa.bivizul.a33project.presentation.list

import aaa.bivizul.a33project.presentation.betstratwidget.BetstratButton
import aaa.bivizul.a33project.presentation.betstratwidget.Betstratcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val betstratItemList by component.state.collectAsState()

    if (betstratItemList != null) {
        betstratItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                items(list) { betstratItem ->
                    BetstratButton(
                        onClick = { component.onClickListItemModel(id = betstratItem.id) },
                        text = "${betstratItem.id}. ${betstratItem.betstrattitle}"
                    )
                }
            }
        }
    } else {
        Betstratcp(modifier = modifier)
    }

}