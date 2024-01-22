import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
  var text by remember { mutableStateOf("Hello, World!") }

  MaterialTheme {
    var showContent by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }
    val greeting = remember { "Hello" }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      val m = rememberTextMeasurer()
      Button(
        onClick = { showContent = !showContent; counter += 1 },
        modifier = Modifier
          .drawWithContent {
            drawIntoCanvas {
              drawContent()
              translate(left = 20f, top = 20f) {
                drawRect(color = Color.Green)
                drawCircle(
                  color = Color.Cyan
                )
                drawText(m, "X")
              }
            }
          }
      ) {
        Text("Click me! ($counter)")
      }
      Button(onClick = {
        println("clicked..")
      }) {
        Text("Swap")
      }
      AnimatedVisibility(showContent) {
        Column(
          Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Image(painterResource("compose-multiplatform.xml"), null)
          Text("Compose: $greeting")
        }
      }
    }
  }
}

fun main() = application {
  val windowState = rememberWindowState(size = DpSize(1024.dp, 768.dp))
  Window(
    onCloseRequest = ::exitApplication,
    title = "Tab 3",
    state = windowState
  ) {
    App()
  }
}
