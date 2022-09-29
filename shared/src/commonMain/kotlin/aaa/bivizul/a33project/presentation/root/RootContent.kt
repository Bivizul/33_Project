package aaa.bivizul.a33project.presentation.root

import aaa.bivizul.a33project.presentation.betstratp.BetstratpContent
import aaa.bivizul.a33project.presentation.item.ItemContent
import aaa.bivizul.a33project.presentation.list.ListContent
import aaa.bivizul.a33project.presentation.main.MainContent
import aaa.bivizul.a33project.presentation.settings.SettingsContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun RootContent(
    rootModel: RootModel,
    modifier: Modifier = Modifier
) {

    val childStack by rootModel.childStack.subscribeAsState()

    Children(
        stack = childStack,
        modifier = Modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is RootModel.Child.BetstratpChild -> BetstratpContent(component = child.component)
            is RootModel.Child.MainChild -> MainContent(component = child.component)
            is RootModel.Child.ListChild -> ListContent(component = child.component)
            is RootModel.Child.ItemChild -> ItemContent(component = child.component)
            is RootModel.Child.SettingsChild -> SettingsContent(component = child.component)
        }
    }

}