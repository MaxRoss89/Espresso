import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.espresso.SettingsActivity
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test

class SettingPage {

    @get:Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun mySignature() {
        onView(withChild(withText("Your signature"))).perform(click())
        onView(withClassName(containsString("AppCompatEditText"))).perform(typeText("MyName"))
        onView(withId(android.R.id.button1)).perform(click())
        onView(withText("MyName")).check(matches(isDisplayed()))
    }

    @Test
    fun replyToAll(){
        onView(withText("Default reply action")).perform(click())
        onView(withText("Reply to all")).perform(click())
        onView(withText("Reply to all")).check(matches(isDisplayed()))
    }

    @Test
    fun sync(){
        onView(withText("Download incoming attachments")).check(matches(not(isEnabled())))


    }
}