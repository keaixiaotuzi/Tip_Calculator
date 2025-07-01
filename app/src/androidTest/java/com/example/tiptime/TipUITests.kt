import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToString
import com.example.tiptime.TipTimeLayout
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip(){
        composeTestRule.setContent {
            // Set up your UI here, e.g., TipTimeLayout()
            TipTimeTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    TipTimeLayout()
                }
            }
        }

        // Interact with the UI elements to set the amount and tip percentage
        // For example, you can use composeTestRule.onNodeWithText("Amount").performTextInput("100")
        // and then check the calculated tip value.
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        // Example assertion (you need to replace with actual UI element IDs):
        // composeTestRule.onNodeWithText("Calculated Tip").assertTextEquals("$20.00")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $2.00").assertExists(
            "No node with this text was found."
        )
        }
}