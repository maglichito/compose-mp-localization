import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.greetings
import kotlinproject.composeapp.generated.resources.switch
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        var lang by remember { mutableStateOf(Language.English.isoFormat) }

        LocalizedApp(
            language = lang
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        lang = switchLanguage(lang)
                        changeLang(lang)
                    }
                ) {
                    Text(stringResource(Res.string.switch))
                }

                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text(stringResource(Res.string.greetings))
            }
        }
    }
}

private fun switchLanguage(lang: String) : String{
    return when (lang) {
        Language.English.isoFormat -> Language.Serbian.isoFormat
        Language.Serbian.isoFormat -> Language.English.isoFormat
        else -> Language.English.isoFormat
    }
}