package aaa.bivizul.a33project.presentation.item

import aaa.bivizul.a33project.domain.model.BetstratItem
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<BetstratItem>?>

    data class Model(
        val selectedBetstratItemId: Int
    )

}