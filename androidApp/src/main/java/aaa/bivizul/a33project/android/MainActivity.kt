package aaa.bivizul.a33project.android

import aaa.bivizul.a33project.domain.util.checkBetstratnet
import aaa.bivizul.a33project.domain.util.getBetstratdlg
import aaa.bivizul.a33project.presentation.betstratwidget.Betstratibl
import aaa.bivizul.a33project.presentation.root.RootComponent
import aaa.bivizul.a33project.presentation.root.RootContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xB2966B00),
            primaryVariant = Color(0x9F7C008A),
            secondary = Color(0x9F8D0000),
            onPrimary = Color(0xFFC2C2C2),
            onBackground = Color(0xFFC2C2C2),
        )
    } else {
        lightColors(
            primary = Color(0xB2FFB700),
            background = Color(0x9FE600FF),
            secondary = Color(0x9FFF0000),
            onPrimary = Color(0xFFFFFFFF),
            onBackground = Color(0xFFFFFFFF),
        )
    }
    val typography = Typography(
        h3 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 48.sp
        ),
        h5 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),
        h6 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
    )
    val shapes = Shapes(
        small = RoundedCornerShape(6.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(10.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkBetstratnet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Betstratibl()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                        RootContent(rootModel = root)
                    }
                }
            }
        } else {
            getBetstratdlg(this)
        }
    }
}


