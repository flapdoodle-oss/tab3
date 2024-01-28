import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppTest {
  @get:Rule
  val rule = createComposeRule()

  @Before
  fun beforeEvery() {
    rule.setContent {
      App()
    }
  }

  @Test
  fun `Click changes the text`() {
    rule.onNodeWithText("Click me!").assertExists()
    rule.onNodeWithText("Click me!").performClick()
    rule.waitForIdle()
    rule.onNodeWithTag("response")
      .assertExists()
      .assertTextContains("Compose: Hello, ", substring = true)
  }}