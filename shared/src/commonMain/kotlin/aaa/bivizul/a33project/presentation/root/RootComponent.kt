package aaa.bivizul.a33project.presentation.root

import aaa.bivizul.a33project.data.repository.BetstratItemRepository
import aaa.bivizul.a33project.data.repository.BetstratRepository
import aaa.bivizul.a33project.presentation.betstratp.BetstratpComponent
import aaa.bivizul.a33project.presentation.betstratp.BetstratpModel
import aaa.bivizul.a33project.presentation.item.ItemComponent
import aaa.bivizul.a33project.presentation.item.ItemModel
import aaa.bivizul.a33project.presentation.list.ListComponent
import aaa.bivizul.a33project.presentation.list.ListModel
import aaa.bivizul.a33project.presentation.main.MainComponent
import aaa.bivizul.a33project.presentation.main.MainModel
import aaa.bivizul.a33project.presentation.settings.SettingsComponent
import aaa.bivizul.a33project.presentation.settings.SettingsModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : RootModel, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val betstratRepository = BetstratRepository()
    val betstratItemRepository = BetstratItemRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.BetstratpConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, RootModel.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): RootModel.Child =
        when (config) {
            is Config.BetstratpConfig -> RootModel.Child.BetstratpChild(
                setBetstratp(componentContext)
            )
            is Config.MainConfig -> RootModel.Child.MainChild(
                setMain(componentContext)
            )
            is Config.ListConfig -> RootModel.Child.ListChild(
                setList(componentContext)
            )
            is Config.ItemConfig -> RootModel.Child.ItemChild(
                setItem(componentContext, config)
            )
            is Config.SettingsConfig -> RootModel.Child.SettingsChild(
                setSettings(componentContext)
            )
        }

    private fun setBetstratp(
        componentContext: ComponentContext
    ): BetstratpModel = BetstratpComponent(
        componentContext = componentContext,
        context = context,
        betstratRepository = betstratRepository,
        onReplaceToMain = {
            navigation.replaceCurrent(Config.MainConfig)
        }
    )

    private fun setMain(
        componentContext: ComponentContext
    ): MainModel = MainComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.ListConfig)
            println("push onClickList")
        },
        onClickSettings = {
            navigation.push(Config.SettingsConfig)
            println("push onClickSettings")
        }
    )

    private fun setList(
        componentContext: ComponentContext
    ): ListModel = ListComponent(
        componentContext = componentContext,
        betstratItemRepository = betstratItemRepository,
        onClickListItem = { itemId ->
            navigation.push(Config.ItemConfig(itemId = itemId))
        },
    )

    private fun setItem(
        componentContext: ComponentContext,
        config: Config.ItemConfig
    ): ItemModel = ItemComponent(
        componentContext = componentContext,
        betstratItemRepository = betstratItemRepository,
        betstratItemId = config.itemId
    )

    private fun setSettings(
        componentContext: ComponentContext
    ): SettingsModel = SettingsComponent(
        componentContext = componentContext,
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object BetstratpConfig : Config()

        @Parcelize
        object MainConfig : Config()

        @Parcelize
        object ListConfig : Config()

        @Parcelize
        data class ItemConfig(val itemId: Int) : Config()

        @Parcelize
        object SettingsConfig : Config()
    }
}