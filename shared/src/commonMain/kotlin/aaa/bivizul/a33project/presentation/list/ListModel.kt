package aaa.bivizul.a33project.presentation.list

import aaa.bivizul.a33project.domain.model.BetstratItem
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<BetstratItem>?>

    fun onClickListItemModel(id: Int)

}