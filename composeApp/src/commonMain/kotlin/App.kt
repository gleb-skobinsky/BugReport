import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

val textGradient = Brush.horizontalGradient(
    listOf(Color.Green, Color.Magenta)
)

@Composable
@Preview
fun App() {
    MaterialTheme {
        val annotatedString = remember {
            buildAnnotatedString {
                pushStyle(SpanStyle(fontSize = 56.sp))
                withStyle(SpanStyle(brush = textGradient)) {
                    append("Text with gradient")
                }
                withStyle(SpanStyle(color = Color.Black)) {
                    append(", and without")
                }
            }
        }
        Box(Modifier.fillMaxSize(), Alignment.Center) {
            Text(annotatedString, textAlign = TextAlign.Center, lineHeight = 64.sp)
        }
    }
}