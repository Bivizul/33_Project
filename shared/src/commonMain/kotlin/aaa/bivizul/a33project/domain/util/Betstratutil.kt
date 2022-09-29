package aaa.bivizul.a33project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val betstratIoDispatcher: CoroutineContext
internal expect val betstratUiDispatcher: CoroutineContext

internal expect fun getBetstratmm(): String
internal expect fun getBetstratsim(betstratcon: Any): String
internal expect fun getBetstratid(betstratcon: Any): String
internal expect fun getBetstratl(): String
internal expect fun getBetstratt(): String
internal expect fun getBetstratdlg(betstratcon: Any)
internal expect fun checkBetstratnet(betstratcon: Any): Boolean
internal expect fun sigBetstratoff()
internal expect fun getBetstratact(betstratact: Any, betstraturl: String)

