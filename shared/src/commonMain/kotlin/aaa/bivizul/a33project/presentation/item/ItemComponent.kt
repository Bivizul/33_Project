package aaa.bivizul.a33project.presentation.item

import aaa.bivizul.a33project.data.repository.BetstratItemRepository
import aaa.bivizul.a33project.domain.model.BetstratItem
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    betstratItemRepository: BetstratItemRepository,
    betstratItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedBetstratItemId = betstratItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<BetstratItem>?> =
        betstratItemRepository.betstratItemList

}