package aaa.bivizul.a33project.presentation.root

import aaa.bivizul.a33project.presentation.betstratp.BetstratpModel
import aaa.bivizul.a33project.presentation.item.ItemModel
import aaa.bivizul.a33project.presentation.list.ListModel
import aaa.bivizul.a33project.presentation.main.MainModel
import aaa.bivizul.a33project.presentation.settings.SettingsModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class BetstratpChild(val component: BetstratpModel) : Child()
        class MainChild(val component: MainModel) : Child()
        class ListChild(val component: ListModel) : Child()
        class ItemChild(val component: ItemModel) : Child()
        class SettingsChild(val component: SettingsModel) : Child()
    }

}