package aaa.bivizul.a33project.presentation.betstratp

import aaa.bivizul.a33project.data.repository.BetstratRepository
import aaa.bivizul.a33project.domain.model.Betstrat
import aaa.bivizul.a33project.domain.model.Betstratg
import aaa.bivizul.a33project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class BetstratpComponent(
    componentContext: ComponentContext,
    context: Any,
    betstratRepository: BetstratRepository,
    private val onReplaceToMain: () -> Unit
) : BetstratpModel, ComponentContext by componentContext {

    private val _models = MutableValue(BetstratpModel.Model(activity = context))
    override val models: Value<BetstratpModel.Model> = _models
    override val state: StateFlow<Betstratg?> = betstratRepository.betstratg

    init {
        try {
            betstratRepository.getBetstratg(
                Betstrat(
                    getBetstratmm(),
                    getBetstratsim(context),
                    getBetstratid(context),
                    getBetstratl(),
                    getBetstratt()
                )
            )
        } catch (e: Exception) {
            getBetstratdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}