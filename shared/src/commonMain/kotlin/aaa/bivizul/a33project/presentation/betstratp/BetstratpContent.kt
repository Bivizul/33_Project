package aaa.bivizul.a33project.presentation.betstratp

import aaa.bivizul.a33project.domain.model.Betstratvar
import aaa.bivizul.a33project.domain.util.getBetstratact
import aaa.bivizul.a33project.domain.util.sigBetstratoff
import aaa.bivizul.a33project.presentation.betstratwidget.Betstratcp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun BetstratpContent(
    component: BetstratpModel,
    modifier: Modifier = Modifier
) {

    val betstratg by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    LaunchedEffect(key1 = true) {
        delay(3000)
        betstratg?.betstratg?.let {
            if (it == Betstratvar.BSVNO.bsv) {
                component.onReplace()
            } else if (it == Betstratvar.BSVNP.bsv) {
                sigBetstratoff()
                component.onReplace()
            } else {
                getBetstratact(model.activity, it)
            }
        }
    }

    Betstratcp(modifier = modifier)

}