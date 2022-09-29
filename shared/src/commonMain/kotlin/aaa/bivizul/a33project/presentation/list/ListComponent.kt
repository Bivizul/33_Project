package aaa.bivizul.a33project.presentation.list

import aaa.bivizul.a33project.data.repository.BetstratItemRepository
import aaa.bivizul.a33project.domain.model.BetstratItem
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    betstratItemRepository: BetstratItemRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<BetstratItem>?> = betstratItemRepository.betstratItemList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}