package ru.iteco.fmhandroid.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class Okl23Test {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun okl23Test() {
        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(
                withText("password2"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(pressImeActionButton())

        val materialButton = onView(
            allOf(
                withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        1
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_main),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val materialTextView = onView(
            allOf(
                withId(android.R.id.title), withText("About"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.about_back_image_button),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_about),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val appCompatImageButton3 = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_main),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val materialTextView2 = onView(
            allOf(
                withId(android.R.id.title), withText("Claims"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView2.perform(click())

        val appCompatImageButton4 = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_list_claim),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton4.perform(click())

        val materialTextView3 = onView(
            allOf(
                withId(android.R.id.title), withText("Main"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView3.perform(click())

        val appCompatImageButton5 = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_main),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton5.perform(click())

        val materialTextView4 = onView(
            allOf(
                withId(android.R.id.title), withText("News"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView4.perform(click())

        val compoundButton = onView(
            allOf(
                withId(R.id.edit_news_material_button),
                withParent(withParent(withId(R.id.container_list_news_include))),
                isDisplayed()
            )
        )
        compoundButton.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
