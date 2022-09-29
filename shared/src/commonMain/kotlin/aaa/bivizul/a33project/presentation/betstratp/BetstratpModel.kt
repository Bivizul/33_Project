package aaa.bivizul.a33project.presentation.betstratp

import aaa.bivizul.a33project.domain.model.Betstratg
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface BetstratpModel {

    val models: Value<Model>
    val state: StateFlow<Betstratg?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}