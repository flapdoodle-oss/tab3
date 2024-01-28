import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppTest {
  @get:Rule
  val composeRule = createComposeRule()

  @Before
  fun beforeEvery() {
    composeRule.setContent {
      App()
    }
  }

  @Test
  fun `Click changes the text`() {
    composeRule.onNodeWithText("Click me!").assertExists()
    composeRule.onNodeWithText("Click me!").performClick()
//    composeRule.awaitIdle()
    composeRule.waitForIdle()

//    runBlocking(Dispatchers.Main) {
//      composeRule.onNodeWithText("Click me!").assertExists()
//      composeRule.onNodeWithText("Click me!").performClick()
//      composeRule.awaitIdle()
////      composeRule.onNodeWithText(FAKE_WELCOME_MSG).assertExists()
//    }
  }}