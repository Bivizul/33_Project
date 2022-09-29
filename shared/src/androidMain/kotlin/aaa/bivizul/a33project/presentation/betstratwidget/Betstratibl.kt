package aaa.bivizul.a33project.presentation.betstratwidget

import aaa.bivizul.a33project.domain.util.Betstratcon
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage

@Composable
actual fun Betstratibl() {

    val betstratorient = LocalConfiguration.current.orientation
    val betstratImgModel = when (betstratorient) {
        Configuration.ORIENTATION_PORTRAIT -> Betstratcon.BETSTRATBV
        else -> Betstratcon.BETSTRATBH
    }

    AsyncImage(
        model = betstratImgModel,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )

}